package es.um.asio.service.filter.article;

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
public class ArticleFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7608048444987210263L;
	
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
	
	/* Fields not included in model */
	
	/**
	 * The year from
	 */
	private String yearFrom;
	
	/**
	 * The year to
	 */
	private String yearTo;
}
