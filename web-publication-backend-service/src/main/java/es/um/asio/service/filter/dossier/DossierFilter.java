package es.um.asio.service.filter.dossier;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class DossierFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class DossierFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -892022794320478894L;

	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The ocicnum
	 */
	private String ocicnum;
	
	/**
	 * The date
	 */
	private String title;
}
