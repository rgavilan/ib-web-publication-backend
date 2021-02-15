package es.um.asio.service.proxy.researchstaff;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.PersonDto;
import es.um.asio.service.filter.researchstaff.ResearchStaffFilter;

public interface ResearchStaffProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<PersonDto>
	 */
	Page<PersonDto> findPaginated(ResearchStaffFilter filter, Pageable pageable);
}
