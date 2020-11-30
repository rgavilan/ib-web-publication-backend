package es.um.asio.service.proxy.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.model.FusekiResponse;

public interface ArticleProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(ArticleFilter filter, Pageable pageable);
}
