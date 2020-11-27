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

	/** The description. */
	private String description;

	/**
	 * The fin fin
	 */
	private String fin;
	
	/**
	 * The fin id
	 */
	private String id;
	
	/**
	 * The fin ini
	 */
	private String ini;

	/**
	 * The fin name
	 */
	private String name;
	
	/**
	 * The fin tipo
	 */
	private String tipo;
	
}
