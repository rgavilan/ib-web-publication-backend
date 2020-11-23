package es.um.asio.service.util;

public class WebAplicationException extends RuntimeException {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6349340066769541752L;

	/**
	 * Instantiates a new exceptcion.
	 */
	public WebAplicationException() {
		super();
	}

	public WebAplicationException(String message) {
		super(message);
	}
}
