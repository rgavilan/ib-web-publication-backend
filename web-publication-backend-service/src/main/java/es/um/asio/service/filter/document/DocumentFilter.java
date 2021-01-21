package es.um.asio.service.filter.document;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class DocumentFilter.
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
	 * The id
	 */
	private String id;
	
	/**
	 * The isCoauthored
	 */
	private String isCoauthored;
	
	/**
	 * The topic
	 */
	private String topic;

	/**
	 * The year
	 */
	private String year;
	
	/**
	 * The types
	 */
	private String types;
	
	/**
	 * The year from
	 */
	private String yearFrom;
	
	/**
	 * The year to
	 */
	private String yearTo;
}
