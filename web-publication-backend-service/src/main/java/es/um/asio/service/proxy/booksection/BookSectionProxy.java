package es.um.asio.service.proxy.booksection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.BookSectionDto;
import es.um.asio.service.filter.booksection.BookSectionFilter;

public interface BookSectionProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<BookSectionDto>
	 */
	Page<BookSectionDto> findPaginated(BookSectionFilter filter, Pageable pageable);
}
