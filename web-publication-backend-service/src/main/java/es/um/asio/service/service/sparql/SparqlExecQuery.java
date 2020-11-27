package es.um.asio.service.service.sparql;

import org.springframework.data.domain.Page;

import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;

public interface SparqlExecQuery {

	Page<FusekiResponse> run(PageableQuery page);
}
