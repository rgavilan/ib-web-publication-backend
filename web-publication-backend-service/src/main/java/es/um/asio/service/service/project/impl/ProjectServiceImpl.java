package es.um.asio.service.service.project.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.sparql.SparqlExecQuery;
import es.um.asio.service.service.sparql.impl.SparqlExecQueryImpl;

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

		// SACAR EL ORDER DE LA QUERY
		Sort sort = pageable.getSort();
		String propertie = null;
		Direction direction = Direction.ASC;

		for (Sort.Order order : sort) {
			propertie = order.getProperty();
			direction = order.getDirection();
		}

		// Create a new query
		String queryString = "SELECT  *\r\n" + "WHERE {\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/name> ?name .\r\n"
				+ (StringUtils.isEmpty(filter.getName()) ? "" : "FILTER (?name = \"" + filter.getName() + "\"@es) .")
				+ "   ?x <http://hercules.org/um/es-ES/rec/description> ?description .\r\n"
				+ (StringUtils.isEmpty(filter.getDescription()) ? ""
						: "FILTER (?name = \"" + filter.getDescription() + "\"@es) .")
				+ "   ?x <http://hercules.org/um/es-ES/rec/ini> ?ini .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/fin> ?fin .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/id> ?id .\r\n"
				+ "  ?x <http://hercules.org/um/es-ES/rec/tipo> ?tipo .\r\n" + "}"
				+ (StringUtils.isEmpty(propertie) ? "" : "ORDER by " + direction + " (?" + propertie + ")");

		// String result = serviceSPARQL.getResponseTrellis(queryString);

		this.logger.info("Query: {}", queryString);
		
		// Page<String> page = new SparqlExecQueryImpl().getResponseTrellis(queryString, pageable);

		Page<String> page = serviceSPARQL.getResponseTrellis(queryString, pageable);
		
		return page;
	}

}
