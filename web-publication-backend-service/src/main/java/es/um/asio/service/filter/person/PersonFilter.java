package es.um.asio.service.filter.person;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class PersonFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class PersonFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5227214432697152423L;
	
	/**
	 * The id
	 */
	private String id;
}
