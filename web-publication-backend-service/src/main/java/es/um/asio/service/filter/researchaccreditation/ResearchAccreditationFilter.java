package es.um.asio.service.filter.researchaccreditation;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ResearchAccreditationFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ResearchAccreditationFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5819170281945081249L;

	/**
	 * The dateIssued
	 */
	private String dateIssued;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The governingAuthority
	 */
	private String governingAuthority;
	
	/**
	 * The hasSubjectArea
	 */
	private String hasSubjectArea;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The title
	 */
	private String title;
}
