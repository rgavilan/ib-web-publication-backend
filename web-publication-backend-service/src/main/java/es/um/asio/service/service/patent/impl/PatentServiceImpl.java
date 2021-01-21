package es.um.asio.service.service.patent.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.patent.PatentService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class PatentServiceImpl implements PatentService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(PatentServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;

	@Override
	public Page<FusekiResponse> findPaginated(PatentFilter filter, Pageable pageable) {
		logger.info("Searching patents with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	public String filtersChunk(PatentFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		if (filter != null) {

			if (StringUtils.isNotBlank(filter.getDate())) {
				strBuilder.append("FILTER (?date = \"");
				strBuilder.append(filter.getDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getExpirationDate())) {
				strBuilder.append("FILTER (?expirationDate = \"");
				strBuilder.append(filter.getExpirationDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}

			if (StringUtils.isNotBlank(filter.getId())) {
				strBuilder.append("FILTER (?id = \"");
				strBuilder.append(filter.getId());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}

			if (StringUtils.isNotBlank(filter.getTopic())) {
				strBuilder.append("FILTER (LANG(?topic) = \"");
				strBuilder.append(filter.getLanguage().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?topic, \"");
				strBuilder.append(filter.getTopic());
				strBuilder.append("\", \"i\")) . ");
			}
		}
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity() {
		return new Entity("Patent", "date", "expirationDate", "id", "topic");
	}

}
