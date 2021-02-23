package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class InvoiceDto.
 */
@Getter
@Setter
public class InvoiceDto {
	
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
	 * The summary
	 */
	private String summary;
}
