package es.um.asio.service.proxy.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.filter.article.ArticleFilter;

public interface ArticleProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ArticleDto>
	 */
	Page<ArticleDto> findPaginated(ArticleFilter filter, Pageable pageable);
}
