package es.um.asio.service.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class PageImplHelper<T> extends PageImpl<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2432387713559408463L;

	/**
	 * Instantiates a new page impl helper.
	 */
	public PageImplHelper() {
		super(new ArrayList<>());
	}

	/**
	 * Instantiates a new page impl helper.
	 *
	 * @param content
	 *            the content
	 * @param pageable
	 *            the pageable
	 * @param total
	 *            the total
	 */
	public PageImplHelper(final List<T> content, final Pageable pageable, final long total) {
		super(content, pageable, total);
	}

	/**
	 * Instantiates a new page impl helper.
	 *
	 * @param content
	 *            the content
	 */
	public PageImplHelper(final List<T> content) {
		super(content);
	}

	/**
	 * Adds the.
	 *
	 * @param element
	 *            the element
	 */
	public void add(final T element) {
		this.getContent().add(element);
	}

	/**
	 * Sets the size.
	 *
	 * @param size
	 *            the new size
	 */
	public void setSize(final int size) {
		// empty
	}
}
