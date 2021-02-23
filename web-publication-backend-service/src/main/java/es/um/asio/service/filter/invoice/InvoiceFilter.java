package es.um.asio.service.filter.invoice;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InvoiceFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class InvoiceFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6475176656211222399L;

	/**
	 * The date
	 */
	private String dateTime;
	
	/**
	 * The doi
	 */
	private String doi;
	
	/**
	 * The endPage
	 */
	private String endPage;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The keyword
	 */
	private String keyword;
	
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
