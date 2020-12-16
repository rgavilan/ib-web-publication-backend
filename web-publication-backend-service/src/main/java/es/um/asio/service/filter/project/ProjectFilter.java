package es.um.asio.service.filter.project;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class ProjectFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ProjectFilter extends Filter {

	private static final long serialVersionUID = -1586947094505235656L;

	/**
	 * The end
	 */
	private String end;
	
	/** 
	 * The fund. 
	 */
	private String fund;
	
	/**
	 * The id
	 */
	private String id;

	/**
	 * The name
	 */
	private String name;
	
	/**
	 * The start
	 */
	private String start;
	
	/**
	 * The tipo
	 */
	private String tipo;
	
}
