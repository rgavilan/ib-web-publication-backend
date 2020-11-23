package es.um.asio.service.service.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.project.ProjectFilter;

public interface ProjectService {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Paginación ProjectDto
	 */
	Page<String> findPaginated(ProjectFilter filter, Pageable pageable);

}
