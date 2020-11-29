package es.um.asio.service.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * The Class Entity.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
@EqualsAndHashCode
public class Entity implements Serializable {

	private static final long serialVersionUID = -969930909950320919L;
	
	/** The fields. */
	private List<String> fields;
	
	/** The entity. */
	private String entity;
	
	/**
	 * Instantiates a new entity.
	 *
	 * @param entity the entity
	 * @param fields the fields
	 */
	public Entity(String entity, String... fields) {
		this.entity = entity;
		this.fields = Arrays.asList(fields);  
	}
}
