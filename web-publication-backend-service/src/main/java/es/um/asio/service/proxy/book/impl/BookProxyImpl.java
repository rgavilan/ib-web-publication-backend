package es.um.asio.service.proxy.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.book.BookProxy;
import es.um.asio.service.service.book.BookService;

/**
 * Implementación del Proxy para Libros
 *
 */
@Service
public class BookProxyImpl implements BookProxy {

	@Autowired
	private BookService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(BookFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
