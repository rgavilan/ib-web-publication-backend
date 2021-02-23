package es.um.asio.service.filter.bookchapter;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class BookChapterFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class BookChapterFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1228060436884250835L;

	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The doi
	 */
	private String doi;
	
	/**
	 * The edition
	 */
	private String edition;
	
	/**
	 * The endPage
	 */
	private String endPage;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The placeOfPublication
	 */
	private String placeOfPublication;
	
	/**
	 * The publishedIn
	 */
	private String publishedIn;
	
	/**
	 * The startPage
	 */
	private String startPage;
	
	/**
	 * The title
	 */
	private String title;
	
	/**
	 * The summary
	 */
	private String summary;
}
