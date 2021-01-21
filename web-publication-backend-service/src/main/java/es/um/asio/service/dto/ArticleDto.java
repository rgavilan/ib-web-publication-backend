package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The class ArticleDto
 */
@Getter
@Setter
public class ArticleDto {

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
