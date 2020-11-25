package es.um.asio.service.filter.project;

import es.um.asio.service.filter.Filter;


/**
 * The Class ProjectFilter.
 */
public class ProjectFilter extends Filter {

	private static final long serialVersionUID = -1586947094505235656L;

	/** The description. */
	private String description;
	
	/** The name. */
	private String name;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProjectFilter [description=" + description + ", name=" + name + ", language=" + language + "]";
	}

}
