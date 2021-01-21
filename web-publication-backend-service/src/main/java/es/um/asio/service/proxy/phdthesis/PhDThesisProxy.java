package es.um.asio.service.proxy.phdthesis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.PhDThesisDto;
import es.um.asio.service.filter.phdthesis.PhDThesisFilter;

public interface PhDThesisProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<PhDThesisDto>
	 */
	Page<PhDThesisDto> findPaginated(PhDThesisFilter filter, Pageable pageable);
}
