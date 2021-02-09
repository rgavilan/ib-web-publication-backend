package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class BookChapterDto.
 */
@Getter
@Setter
public class BookChapterDto {

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
	 * The publishedIn
	 */
	private String publishedIn;
	
	/**
	 * The startPage
	 */
	private String startPage;
	
	/**
	 * The summary
	 */
	private String summary;
}
