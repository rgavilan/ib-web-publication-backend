package es.um.asio.service.filter.expo;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ExpoFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ExpoFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6905629948517776190L;

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
