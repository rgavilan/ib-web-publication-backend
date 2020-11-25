package es.um.asio.service.filter;

import java.io.Serializable;

import es.um.asio.abstractions.constants.Constants;

/**
 * Abstract class in order to wrap the filters.
 */
public abstract class Filter implements Serializable {
	
	private static final long serialVersionUID = -9184912387085355860L;
	
	/** The language. SPANISH by default */
	protected String language = "@".concat(Constants.SPANISH_LANGUAGE_SHORT);

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
