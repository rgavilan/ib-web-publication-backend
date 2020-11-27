package es.um.asio.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class FusekiResponse.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class FusekiResponse {
	
	/** The head. */
	private Object head;
	
	/** The results. */
	private Object results;
}
