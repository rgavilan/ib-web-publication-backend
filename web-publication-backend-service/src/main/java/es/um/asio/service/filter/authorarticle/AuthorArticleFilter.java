package es.um.asio.service.filter.authorarticle;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class AuthorArticleFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class AuthorArticleFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3998937405685156082L;

	/**
	 * The fin centro
	 */
	private String centro;
	
	/**
	 * The fin dpto
	 */
	private String dpto;
	
	/**
	 * The fin id
	 */
	private String id;
}
