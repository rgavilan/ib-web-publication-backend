package es.um.asio.service.service.sparql;

import java.util.LinkedHashMap;

import org.springframework.data.domain.Page;

import es.um.asio.service.model.PageableQuery;

public interface SparqlExecQuery {

	Page<LinkedHashMap> run(PageableQuery page);
}
