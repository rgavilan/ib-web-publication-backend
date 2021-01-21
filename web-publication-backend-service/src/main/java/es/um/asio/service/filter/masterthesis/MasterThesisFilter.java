package es.um.asio.service.filter.masterthesis;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class MasterThesisFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class MasterThesisFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3901458210253686293L;
	
	/**
	 * The date
	 */
	private String date;

	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;
}
