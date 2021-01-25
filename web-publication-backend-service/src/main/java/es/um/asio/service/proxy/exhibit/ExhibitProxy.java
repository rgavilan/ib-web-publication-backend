package es.um.asio.service.proxy.expo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ExpoDto;
import es.um.asio.service.filter.expo.ExpoFilter;

public interface ExpoProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ExpoDto>
	 */
	Page<ExpoDto> findPaginated(ExpoFilter filter, Pageable pageable);
}
