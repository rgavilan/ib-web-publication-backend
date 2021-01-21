package es.um.asio.service.filter.phdthesis;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class PhDThesisFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class PhDThesisFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4280705222425402676L;

	/**
	 * The awarded
	 */
	private String awarded;
	
	/**
	 * The date
	 */
	private String date;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The id
	 */
	private String topic;
}
