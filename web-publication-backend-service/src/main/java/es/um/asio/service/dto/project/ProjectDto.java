package es.um.asio.service.dto.project;

import java.io.Serializable;
import java.util.Date;

/**
 * Dto clase Proyecto
 *
 */
public class ProjectDto implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4195615665497534163L;
	
	
	/**
	 * descripción proyecto
	 */
	private String description;
	
	/**
	 * Fecha fin proyecto
	 */
	private Date fin;
	
	/**
	 * ID
	 */
	private String id;
	
	/**
	 * Fecha inicio Proyecto
	 */
	private Date ini;
	
	/**
	 * Nombre proyecto
	 */
	private String name;
	
	/**
	 * Tipo Proyecto
	 */
	private String tipo;

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
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ini
	 */
	public Date getIni() {
		return ini;
	}

	/**
	 * @param ini the ini to set
	 */
	public void setIni(Date ini) {
		this.ini = ini;
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

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
