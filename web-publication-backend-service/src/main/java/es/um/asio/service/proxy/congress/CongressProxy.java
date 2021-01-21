package es.um.asio.service.proxy.congress;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.CongressDto;
import es.um.asio.service.filter.congress.CongressFilter;

/**
 * Implementación del Proxy para Articulos
 *
 */
@Service
public interface CongressProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<CongressDto>
	 */
	Page<CongressDto> findPaginated(CongressFilter filter, Pageable pageable);
}
