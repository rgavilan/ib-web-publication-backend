package es.um.asio.service.proxy.exhibit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ExhibitDto;
import es.um.asio.service.filter.exhibit.ExhibitFilter;

public interface ExhibitProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ExhibitDto>
	 */
	Page<ExhibitDto> findPaginated(ExhibitFilter filter, Pageable pageable);
}
