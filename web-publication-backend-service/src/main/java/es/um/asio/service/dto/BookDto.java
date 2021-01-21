package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class BookDto.
 */
@Getter
@Setter
public class BookDto {

	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The isCoauthored
	 */
	private String isCoauthored;
	
	/**
	 * The topic
	 */
	private String topic;

	/**
	 * The year
	 */
	private String year;
}
