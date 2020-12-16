package es.um.asio.service.filter.invoice;

import es.um.asio.service.filter.Filter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The Class InvoiceFilter.
 */
@Getter
@Setter
@ToString(includeFieldNames = true)
public class InvoiceFilter extends Filter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6475176656211222399L;

	/**
	 * The id
	 */
	private String id;
}
