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
	 * The fin date
	 */
	private String date;

	/**
	 * The fin expirationDate
	 */
	private String expirationDate;

	/**
	 * The fin id
	 */
	private String id;

	/**
	 * The fin topic
	 */
	private String topic;
}
