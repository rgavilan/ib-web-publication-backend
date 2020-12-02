package es.um.asio.service.proxy.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.model.FusekiResponse;

public interface BookProxy {
	
	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(BookFilter filter, Pageable pageable);
}
