package es.um.asio.service.service.sparql;

import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.Filter;
import es.um.asio.service.model.Entity;

public interface QueryBuilder {

	String createSelectQuery(Entity entity, Filter filter, Pageable pageable);
	
	String createCountQuery(Entity entity, Filter filter, Pageable pageable);
}
