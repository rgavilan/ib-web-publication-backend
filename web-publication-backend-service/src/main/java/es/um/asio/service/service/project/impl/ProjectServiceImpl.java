package es.um.asio.service.service.project.impl;

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
	SparqlExecQuery serviceSPARQL;

	@Override
	public Page<String> findPaginated(ProjectFilter filter, Pageable pageable) {
		logger.info("ProjectServiceImpl start");
		
		Entity entity = new Entity("Proyecto", "id", "name");
		
		PageableQuery pageableQuery = new PageableQuery(entity, filter, pageable);
		Page<String> page = serviceSPARQL.run(pageableQuery);
		
		return page;
	}
}
