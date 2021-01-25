package es.um.asio.service.proxy.conference;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ConferenceDto;
import es.um.asio.service.filter.conference.ConferenceFilter;

/**
 * Implementación del Proxy para Articulos
 *
 */
@Service
public interface ConferenceProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ConferenceDto>
	 */
	Page<ConferenceDto> findPaginated(ConferenceFilter filter, Pageable pageable);
}
