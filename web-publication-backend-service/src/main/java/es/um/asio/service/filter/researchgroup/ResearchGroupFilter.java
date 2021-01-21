package es.um.asio.service.filter.researchgroup;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ResearchGroupFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ResearchGroupFilter extends Filter {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -701575400923362443L;
	
	/**
	 * The id
	 */
	private String id;
	
	/**
	 * The topic
	 */
	private String topic;
}
