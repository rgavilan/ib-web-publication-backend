package es.um.asio.service.filter.projectexpense;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ProjectExpenseFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ProjectExpenseFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8592865036159048314L;

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
	 * The id
	 */
	private String id;
	
	/**
	 * The monetaryAmount
	 */
	private String monetaryAmount;
	
	/**
	 * The title
	 */
	private String title;
}
