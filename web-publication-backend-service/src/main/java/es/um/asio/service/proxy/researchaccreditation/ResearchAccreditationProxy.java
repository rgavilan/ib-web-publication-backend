package es.um.asio.service.proxy.researchaccreditation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ResearchAccreditationDto;
import es.um.asio.service.filter.researchaccreditation.ResearchAccreditationFilter;

public interface ResearchAccreditationProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ResearchAccreditationDto>
	 */
	Page<ResearchAccreditationDto> findPaginated(ResearchAccreditationFilter filter, Pageable pageable);
}
