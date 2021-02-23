package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The class DossierDto
 */
@Getter
@Setter
public class DossierDto {
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The date
	 */
	private String title;

	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The ocicnum
	 */
	private String ocicnum;
}
