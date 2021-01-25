package es.um.asio.service.filter.book;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class BookFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class BookFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8003420601843949425L;
	
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
	 * The iccn
	 */
	private String iccn;
	
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
	
	/* Fields not included in model */
	
	/**
	 * The year from
	 */
	private String dateFrom;
	
	/**
	 * The year to
	 */
	private String dateTo;
}
