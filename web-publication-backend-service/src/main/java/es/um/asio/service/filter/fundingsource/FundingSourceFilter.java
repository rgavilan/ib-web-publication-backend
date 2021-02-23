package es.um.asio.service.filter.fundingsource;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class FoundingSourceFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class FundingSourceFilter extends Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3038207282170413433L;

	/**
	 * The funds
	 */
	private String funds;
	
	/**
	 * The id
	 */
	private String id;
}
