package es.um.asio.service.service.project.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class ProjectServiceImpl implements ProjectService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;

	@Override
	public Page<String> findPaginated(ProjectFilter filter, Pageable pageable) {
		logger.info("ProjectServiceImpl start");

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		Page<String> page = serviceSPARQL.run(pageableQuery);

		return page;
	}

	protected String filtersChunk(ProjectFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		if (filter != null) {
			if (StringUtils.isNotBlank(filter.getName())) {
				strBuilder.append("FILTER (?name = \"");
				strBuilder.append(filter.getName());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			if (StringUtils.isNotBlank(filter.getDescription())) {
				strBuilder.append("FILTER (?description = \"");
				strBuilder.append(filter.getDescription());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
		}
		return strBuilder.toString();
	}
	
	protected Entity retrieveEntity() {
		return new Entity("Proyecto", "name", "description");
	}

}
