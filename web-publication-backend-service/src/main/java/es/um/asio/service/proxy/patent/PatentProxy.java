package es.um.asio.service.proxy.patent;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.model.FusekiResponse;

/**
 * Interfaz Proxy Patente
 *
 */
public interface PatentProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(PatentFilter filter, Pageable pageable);

}
