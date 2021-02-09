package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class BookSectionDto.
 */
@Getter
@Setter
public class BookSectionDto {

	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The title
	 */
	private String title;

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
	 * The placeOfPublication
	 */
	private String placeOfPublication;
	
	/**
	 * The startPage
	 */
	private String startPage;
}
