package es.um.asio.service.filter.congress;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class CongressFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class CongressFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8763345133106144921L;
	
	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The id
	 */
	private String id;

	/**
	 * The place
	 */
	private String place;
	
	/**
	 * The topic
	 */
	private String topic;
}
