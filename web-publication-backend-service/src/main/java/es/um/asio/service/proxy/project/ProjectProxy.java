package es.um.asio.service.proxy.project;

import java.util.LinkedHashMap;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.project.ProjectFilter;

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
	Page<LinkedHashMap> findPaginated(ProjectFilter filter, Pageable pageable);
}
