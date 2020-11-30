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
public class ArticleFilter extends Filter {/**
	 * 
	 */
	private static final long serialVersionUID = 7608048444987210263L;

	/**
	 * The fin coautoria
	 */
	private String coautoria;
	
	/**
	 * The fin id
	 */
	private String id;
	
	/**
	 * The fin name
	 */
	private String name;
}
