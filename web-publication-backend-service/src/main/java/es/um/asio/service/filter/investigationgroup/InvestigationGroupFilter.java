package es.um.asio.service.filter.investigationgroup;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InvestigationGroupFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class InvestigationGroupFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = -701575400923362443L;

	/**
	 * The description
	 */
	private String description;
	
	/**
	 * The id
	 */
	private String id;
}
