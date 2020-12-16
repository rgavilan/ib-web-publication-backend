package es.um.asio.service.proxy.university;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.university.UniversityFilter;
import es.um.asio.service.model.FusekiResponse;

public interface UniversityProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(UniversityFilter filter, Pageable pageable);
}
