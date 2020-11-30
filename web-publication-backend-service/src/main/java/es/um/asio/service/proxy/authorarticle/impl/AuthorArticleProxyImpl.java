package es.um.asio.service.proxy.authorarticle.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.authorarticle.AuthorArticleFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.authorarticle.AuthorArticleProxy;
import es.um.asio.service.service.authorarticle.AuthorArticleService;

/**
 * Implementación del Proxy para AutorArticulos
 *
 */
@Service
public class AuthorArticleProxyImpl implements AuthorArticleProxy {

	@Autowired
	private AuthorArticleService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(AuthorArticleFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
