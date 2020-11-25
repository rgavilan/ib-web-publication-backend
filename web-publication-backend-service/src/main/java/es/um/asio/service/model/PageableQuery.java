package es.um.asio.service.model;

import java.io.Serializable;

import org.springframework.data.domain.Pageable;

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
	
	/** The entity. */
	private Entity entity;
	
	/** The filter. */
	private String filters;
	
	/** The page. */
	private Pageable page;
	
	public PageableQuery(Entity entity, String filters, Pageable page) {
		super();
		this.entity = entity;
		this.filters = filters;
		this.page = page;
	}

}
