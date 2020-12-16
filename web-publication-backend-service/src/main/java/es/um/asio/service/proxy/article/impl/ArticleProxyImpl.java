package es.um.asio.service.proxy.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.article.ArticleProxy;
import es.um.asio.service.service.article.ArticleService;

/**
 * Implementación del Proxy para Articulos
 *
 */
@Service
public class ArticleProxyImpl implements ArticleProxy {

	@Autowired
	private ArticleService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(ArticleFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
