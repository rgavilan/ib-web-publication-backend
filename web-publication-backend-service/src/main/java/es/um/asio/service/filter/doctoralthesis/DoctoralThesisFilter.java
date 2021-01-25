package es.um.asio.service.filter.doctoralthesis;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class PhDThesisFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class DoctoralThesisFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4280705222425402676L;

	/**
	 * The abbreviation
	 */
	private String abbreviation;
	
	/**
	 * The date
	 */
	private String date;
	
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
}
