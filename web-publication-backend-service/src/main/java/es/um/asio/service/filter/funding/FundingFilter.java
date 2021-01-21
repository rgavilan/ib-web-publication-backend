package es.um.asio.service.filter.funding;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class FundingFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class FundingFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6925981466843046610L;

	/**
	 * The id
	 */
	private String id;

	/**
	 * The name
	 */
	private String name;
}
