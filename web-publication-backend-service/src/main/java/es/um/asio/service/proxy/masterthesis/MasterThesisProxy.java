package es.um.asio.service.proxy.masterthesis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.MasterThesisDto;
import es.um.asio.service.filter.masterthesis.MasterThesisFilter;

public interface MasterThesisProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<MasterThesisDto>
	 */
	Page<MasterThesisDto> findPaginated(MasterThesisFilter filter, Pageable pageable);
}
