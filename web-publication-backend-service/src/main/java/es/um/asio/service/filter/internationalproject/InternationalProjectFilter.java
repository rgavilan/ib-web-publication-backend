package es.um.asio.service.filter.internationalproject;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InternationalProjectFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class InternationalProjectFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8125499250820320907L;

	/**
	 * The endDate
	 */
	private String endDate;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;
	
	/**
	 * The objective
	 */
	private String objective;
	
	/**
	 * The startDate
	 */
	private String startDate;
}
