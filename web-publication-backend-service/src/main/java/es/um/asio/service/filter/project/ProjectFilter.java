package es.um.asio.service.filter.project;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class ProjectFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class ProjectFilter extends Filter {

	private static final long serialVersionUID = -1586947094505235656L;

	/**
	 * The endDate
	 */
	private String endDate;
	
	/** 
	 * The id. 
	 */
	private String id;
	
	/**
	 * The name
	 */
	private String name;

	/**
	 * The objective
	 */
	private String objective;
	
	/**
	 * The startDate
	 */
	private String startDate;
}
