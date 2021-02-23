package es.um.asio.service.proxy.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.BookDto;
import es.um.asio.service.filter.book.BookFilter;

public interface BookProxy {
	
	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<BookDto>
	 */
	Page<BookDto> findPaginated(BookFilter filter, Pageable pageable);
}
