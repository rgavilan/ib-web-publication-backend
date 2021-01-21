package es.um.asio.service.proxy.researchgroup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ResearchGroupDto;
import es.um.asio.service.filter.researchgroup.ResearchGroupFilter;

public interface ResearchGroupProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ResearchGroupDto>
	 */
	Page<ResearchGroupDto> findPaginated(ResearchGroupFilter filter, Pageable pageable);
}
