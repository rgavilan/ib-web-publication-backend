package es.um.asio.service.filter.project;

import com.izertis.abstractions.filter.EntityFilter;

/**
 * Clase Filtro Proyecto
 *
 */
public class ProjectFilter implements EntityFilter {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8337481943796647885L;

	/**
	 * descripción proyecto
	 */
	private String description;

	/**
	 * Nombre proyecto
	 */
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
}
