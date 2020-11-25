package es.um.asio.service.service.sparql;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SparqlExecQuery {

	Page<String> run(String query, Pageable pageable);
}
