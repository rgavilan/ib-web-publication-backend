package es.um.asio.service.model;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.Filter;
import es.um.asio.service.service.sparql.QueryBuilder;
import es.um.asio.service.service.sparql.impl.QueryBuilderImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class PageableQuery.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class PageableQuery implements Serializable {

	private static final long serialVersionUID = -5600773325770247728L;

	@Autowired
	private QueryBuilder queryBuilder;
	
	/** The entity. */
	private Entity entity;
	
	/** The filter. */
	private Filter filter;
	
	/** The page. */
	private Pageable page;
	
	
	public PageableQuery(Entity entity, Filter filter, Pageable page) {
		super();
		this.entity = entity;
		this.filter = filter;
		this.page = page;
		this.queryBuilder = new QueryBuilderImpl();
	}
	
	public String selectQuery() {
		return queryBuilder.createSelectQuery(entity, filter, page);
	}
	
	public String countQuery() {
		return queryBuilder.createCountQuery(entity, filter, page);
	}

}
