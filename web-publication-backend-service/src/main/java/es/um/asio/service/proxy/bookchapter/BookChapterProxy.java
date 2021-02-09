package es.um.asio.service.proxy.bookchapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.BookChapterDto;
import es.um.asio.service.filter.bookchapter.BookChapterFilter;

public interface BookChapterProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<BookChapterDto>
	 */
	Page<BookChapterDto> findPaginated(BookChapterFilter filter, Pageable pageable);
}
