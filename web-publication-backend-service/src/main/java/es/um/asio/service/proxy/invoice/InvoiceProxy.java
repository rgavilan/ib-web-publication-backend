package es.um.asio.service.proxy.invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.model.FusekiResponse;

public interface InvoiceProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(InvoiceFilter filter, Pageable pageable);
}
