package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class CongressDto.
 */
@Getter
@Setter
public class ConferenceDto {
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The title
	 */
	private String title;

	/**
	 * The abbreviation
	 */
	private String abbreviation;
	
	/**
	 * The contactInformation
	 */
	private String contactInformation;
	
	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The locality
	 */
	private String locality;
	
	/**
	 * The locatedIn
	 */
	private String locatedIn;
	
	/**
	 * The presents
	 */
	private String presents;
}
