package es.um.asio.service.service.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface BookService {

	/**
	 * Find paginated.
	 *
	 * @param filter the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(BookFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();
}
