package es.um.asio.service.service.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.FusekiResponse;

public interface ProjectService {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Paginación ProjectDto
	 */
	Page<FusekiResponse> findPaginated(ProjectFilter filter, Pageable pageable);

}
