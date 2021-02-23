package es.um.asio.service.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * The class ProjectExpenseDto
 */
@Getter
@Setter
public class ProjectExpenseDto {

	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The title
	 */
	private String title;

	/**
	 * The currency
	 */
	private String currency;
	
	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The expenseModality
	 */
	private String expenseModality;
	
	/**
	 * The hasExpenseClassification
	 */
	private String hasExpenseClassification;
	
	/**
	 * The monetaryAmount
	 */
	private String monetaryAmount;
}
