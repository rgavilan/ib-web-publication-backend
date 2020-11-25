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
		String queryString = "SELECT ?id ?name\r\n" + "WHERE {\r\n"
				+ "   ?x <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://hercules.org/um/es-ES/rec/Patente> .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/id> ?id .\r\n"
				+ "   ?x <http://hercules.org/um/es-ES/rec/name> ?name .\r\n" + "  FILTER (?id = \"39\"@es) .\r\n"
				+ "  FILTER (?name = \"DISPOSITIVO Y MÉTODO PARA INTRODUCIR YO RECOGER FLUIDOS EN EL INTERIOR DEL ÚTERO DE UN ANIMAL\"@es) .\r\n"
				+ "  \r\n" + "}\r\n" + "LIMIT 100 offset 0";


		this.logger.info("Query: {}", queryString);
		

		Page<String> page = serviceSPARQL.run(queryString, pageable);
		
		return page;
	}

}
