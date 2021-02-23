package es.um.asio.service.proxy.booksection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.BookSectionDto;
import es.um.asio.service.filter.booksection.BookSectionFilter;
import es.um.asio.service.mapper.BookSectionMapper;
import es.um.asio.service.proxy.booksection.BookSectionProxy;
import es.um.asio.service.service.booksection.BookSectionService;

/**
 * Implementación del Proxy para BookSection
 *
 */
@Service
public class BookSectionProxyImpl implements BookSectionProxy {

	@Autowired
	private BookSectionService service;
	
	@Autowired
	private BookSectionMapper mapper;
	
	@Override
	public Page<BookSectionDto> findPaginated(BookSectionFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
