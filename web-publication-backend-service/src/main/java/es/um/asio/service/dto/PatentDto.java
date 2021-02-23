package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class PatentDto.
 */
@Getter
@Setter
public class PatentDto {
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The title
	 */
	private String title;

	/**
	 * The dateIssued
	 */
	private String dateIssued;
	
	/**
	 * The doi
	 */
	private String doi;
	
	/**
	 * The endDate
	 */
	private String endDate;
	
	/**
	 * The endPage
	 */
	private String endPage;
	
	/**
	 * The keyword
	 */
	private String keyword;
	
	/**
	 * The mode
	 */
	private String mode;
	
	/**
	 * The startDate
	 */
	private String startDate;
	
	/**
	 * The startPage
	 */
	private String startPage;
	
	/**
	 * The summary
	 */
	private String summary;
}
