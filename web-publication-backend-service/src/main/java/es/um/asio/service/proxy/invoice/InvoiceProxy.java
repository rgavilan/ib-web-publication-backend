package es.um.asio.service.proxy.invoice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.InvoiceDto;
import es.um.asio.service.filter.invoice.InvoiceFilter;

public interface InvoiceProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<InvoiceDto>
	 */
	Page<InvoiceDto> findPaginated(InvoiceFilter filter, Pageable pageable);
}
