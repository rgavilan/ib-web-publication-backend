package es.um.asio.service.filter.patent;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class PatentFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class PatentFilter extends Filter {
	/**
	* 
	*/
	private static final long serialVersionUID = 8008993664632532940L;

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
