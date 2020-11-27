package es.um.asio.service.proxy.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.FusekiResponse;

/**
 * Interfaz Proxy Proyecto
 *
 */
public interface ProjectProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(ProjectFilter filter, Pageable pageable);
}
