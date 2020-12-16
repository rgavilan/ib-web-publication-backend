package es.um.asio.service.filter.document;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ArticleFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class DocumentFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9066425157947222584L;

	/**
	 * The anyo
	 */
	private String anyo;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;
	
	/**
	 * The types
	 */
	private String types;
}
