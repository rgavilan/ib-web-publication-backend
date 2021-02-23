package es.um.asio.service.proxy.internationalproject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.InternationalProjectDto;
import es.um.asio.service.filter.internationalproject.InternationalProjectFilter;

public interface InternationalProjectProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<InternationalProjectDto>
	 */
	Page<InternationalProjectDto> findPaginated(InternationalProjectFilter filter, Pageable pageable);
}
