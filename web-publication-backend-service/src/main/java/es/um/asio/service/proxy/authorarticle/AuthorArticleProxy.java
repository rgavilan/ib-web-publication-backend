package es.um.asio.service.proxy.authorarticle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.authorarticle.AuthorArticleFilter;
import es.um.asio.service.model.FusekiResponse;

public interface AuthorArticleProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(AuthorArticleFilter filter, Pageable pageable);
}
