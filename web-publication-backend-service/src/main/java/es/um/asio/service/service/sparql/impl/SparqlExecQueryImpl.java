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
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class SparqlExecQueryImpl implements SparqlExecQuery {
	
	private final Logger logger = LoggerFactory.getLogger(SparqlExecQueryImpl.class);

	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;
	
	/** The rest template. */
	private RestTemplate restTemplate;
	
	/** The mapper. */
	private ObjectMapper mapper;
	
	
	/**
	 * Instantiates a new sparql exec query impl.
	 */
	public SparqlExecQueryImpl() {
		restTemplate = new RestTemplate();
		mapper = new ObjectMapper();
	}

	/**
	 * Method in order to run the query against Fuseki-Trellis
	 *
	 * @param query the query
	 * @param pageable the pageable
	 * @return the page
	 */
	@Override
	public Page<String> run(String query, Pageable pageable) {
		
		Page<String> result = null;
		List<String> contentResult = new ArrayList<>();

		try {
			ResponseEntity<Object> res = restTemplate.exchange(fusekiTrellisUrl, HttpMethod.POST, getBody(query), Object.class);

			LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) res.getBody();

	
			for (Map.Entry<String, Object> entry : body.entrySet()) {
				contentResult.add(mapper.writeValueAsString(entry));
			}
			
		} catch (Exception e) {
			this.logger.error("Error retrieving results from fuseki cause {}", e.getMessage());
		}

		result = new PageImpl<>(contentResult, pageable, 30);

		return result;
	}

	/**
	 * Gets the headers.
	 *
	 * @return the headers
	 */
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return headers;
	}
	
	/**
	 * Gets the body.
	 *
	 * @param query the query
	 * @return the body
	 */
	private HttpEntity<MultiValueMap<String, String>> getBody(String query) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();	
		params.add("query", query);
		
		HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<>(params, getHeaders());
		
		return body;
	}
}
