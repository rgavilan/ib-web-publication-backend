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
	 * The anyo
	 */
	private String anyo;
	
	/**
	 * The coautoria
	 */
	private String coautoria;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;
}
