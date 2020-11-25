/*
 *
 */
package es.um.asio.service.service.sparql.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.sparql.SparqlExecQuery;

/**
 * The Class SparqlExecQueryImpl.
 */
@Service
public class SparqlExecQueryImpl implements SparqlExecQuery {

	private final Logger logger = LoggerFactory.getLogger(SparqlExecQueryImpl.class);

	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;

	/** The rest template. */
	private final RestTemplate restTemplate;

	/** The mapper. */
	private final ObjectMapper mapper;

	/**
	 * Instantiates a new sparql exec query impl.
	 */
	public SparqlExecQueryImpl() {
		this.restTemplate = new RestTemplate();
		this.mapper = new ObjectMapper();
	}

	/**
	 * Method in order to run the query against Fuseki-Trellis
	 *
	 * @param query    the query
	 * @param pageable the pageable
	 * @return the page
	 */
	@Override
	public Page<String> run(final PageableQuery page) {

		Page<String> result = null;
		List<String> contentResult = new ArrayList<>();
		Integer totalElements = 0;

		try {
			contentResult = this.getElements(page.selectQuery());
			totalElements = this.getTotalElements(page.countQuery());
		} catch (final Exception e) {
			this.logger.error("Error building the page {}", page);
		}

		result = new PageImpl<>(contentResult, page.getPage(), totalElements);

		return result;
	}

	/**
	 * Gets the elements.
	 *
	 * @param query the query
	 * @return the elements
	 * @throws JsonProcessingException the json processing exception
	 */
	private List<String> getElements(final String query) throws JsonProcessingException {
		final List<String> result = new ArrayList<>();

		// call for Fuseki-Trellis
		final ResponseEntity<Object> res = this.callFusekiTrellis(query);

		if ((res != null) && (res.getBody() != null)) {
			final LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) res.getBody();
			for (final Map.Entry<String, Object> entry : body.entrySet()) {
				result.add(this.mapper.writeValueAsString(entry));
			}
		}

		return result;

	}

	private Integer getTotalElements(final String query) {
		Integer result = 0;
		// call for Fuseki-Trellis
		final ResponseEntity<Object> res = this.callFusekiTrellis(query);

		if ((res != null) && (res.getBody() != null)) {
			final LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) res.getBody();

			final LinkedHashMap<String, Object> temp = (LinkedHashMap<String, Object>) body.get("results");
			final ArrayList x = (ArrayList) temp.get("bindings");
			final LinkedHashMap<String, Object> last = (LinkedHashMap<String, Object>) x.get(0);
			final LinkedHashMap<String, Object> lastButNotLeast = (LinkedHashMap<String, Object>) last.get("count");
			final String xy = (String) lastButNotLeast.get("value");
			result = Integer.valueOf(xy);
		}

		return result;
	}

	private ResponseEntity<Object> callFusekiTrellis(final String query) {
		ResponseEntity<Object> result = null;
		try {
			result = this.restTemplate.exchange(this.fusekiTrellisUrl, HttpMethod.POST, this.getBody(query),
					Object.class);

		} catch (final Exception e) {
			this.logger.error("Error retrieving results from fuseki cause {}", e.getMessage());
		}
		return result;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	private HttpHeaders getHeaders() {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}

	/**
	 * Gets the body.
	 *
	 * @param query the query
	 * @return the body
	 */
	private HttpEntity<MultiValueMap<String, String>> getBody(final String query) {
		final MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("query", query);

		final HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, this.getHeaders());

		return body;
	}
}
