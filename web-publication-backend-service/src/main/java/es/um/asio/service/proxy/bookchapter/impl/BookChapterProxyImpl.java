package es.um.asio.service.proxy.bookchapter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.BookChapterDto;
import es.um.asio.service.filter.bookchapter.BookChapterFilter;
import es.um.asio.service.mapper.BookChapterMapper;
import es.um.asio.service.proxy.bookchapter.BookChapterProxy;
import es.um.asio.service.service.bookchapter.BookChapterService;

/**
 * Implementación del Proxy para BookChapter
 *
 */
@Service
public class BookChapterProxyImpl implements BookChapterProxy {

	@Autowired
	private BookChapterService service;
	
	@Autowired
	private BookChapterMapper mapper;
	
	@Override
	public Page<BookChapterDto> findPaginated(BookChapterFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
