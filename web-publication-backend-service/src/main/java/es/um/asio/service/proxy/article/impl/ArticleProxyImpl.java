package es.um.asio.service.proxy.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.mapper.ArticleMapper;
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
	
	@Autowired
	private ArticleMapper mapper;
	
	@Override
	public Page<ArticleDto> findPaginated(ArticleFilter filter, Pageable pageable) {
		Page<FusekiResponse> result = this.service.findPaginated(filter, pageable);
		
		return this.mapper.convertPageFusekiResponseToDto(result);
	}
}
