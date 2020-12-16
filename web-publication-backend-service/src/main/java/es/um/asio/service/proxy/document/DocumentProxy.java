package es.um.asio.service.proxy.document;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.document.DocumentFilter;
import es.um.asio.service.model.FusekiResponse;

public interface DocumentProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(DocumentFilter filter, Pageable pageable);
}
