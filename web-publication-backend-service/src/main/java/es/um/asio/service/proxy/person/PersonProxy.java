package es.um.asio.service.proxy.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.model.FusekiResponse;

public interface PersonProxy {
	
	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(PersonFilter filter, Pageable pageable);
}
