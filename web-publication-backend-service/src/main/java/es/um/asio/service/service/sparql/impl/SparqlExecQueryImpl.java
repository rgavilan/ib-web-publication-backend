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
	
	
	@Override
	public Page<String> getResponseTrellis(String query, Pageable pageable) {

		RestTemplate restTemplate = new RestTemplate();

		Page<String> result = null;
		List<String> contentResult = new ArrayList<>();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();	
		map.add("query", "SELECT ?id ?name\r\n" + "WHERE {\r\n"
				+ "   ?x <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://hercules.org/um/es-ES/rec/Patente> .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/id> ?id .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/name> ?name .\r\n" + "  FILTER (?id = \"39\"@es) .\r\n"
				+ "  FILTER (?name = \"DISPOSITIVO Y MÉTODO PARA INTRODUCIR YO RECOGER FLUIDOS EN EL INTERIOR DEL ÚTERO DE UN ANIMAL\"@es) .\r\n"
				+ "  \r\n" + "}\r\n" + "LIMIT 100 offset 0");

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		try {
			ResponseEntity<Object> res = restTemplate.exchange(fusekiTrellisUrl, HttpMethod.POST, entity, Object.class);

			LinkedHashMap<String, Object> body = (LinkedHashMap<String, Object>) res.getBody();

			ObjectMapper mapper = new ObjectMapper();

			for (Map.Entry<String, Object> entry : body.entrySet()) {
				contentResult.add(mapper.writeValueAsString(entry));
			}
			
		} catch (Exception e) {
			this.logger.error("Error retrieving results from fuseki cause {}", e.getMessage());
		}

		result = new PageImpl<>(contentResult, pageable, 30);

		return result;
	}

}
