package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class MasterThesisDto.
 */
@Getter
@Setter
public class MasterThesisDto {
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;

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
	 * The university
	 */
	private String university;
}
