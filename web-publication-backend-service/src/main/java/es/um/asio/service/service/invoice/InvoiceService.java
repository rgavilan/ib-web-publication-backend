package es.um.asio.service.service.invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface InvoiceService {

	/**
	 * Find paginated.
	 *
	 * @param filter the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(InvoiceFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();
}
