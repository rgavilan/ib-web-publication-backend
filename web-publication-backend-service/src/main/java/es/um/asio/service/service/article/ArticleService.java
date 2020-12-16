package es.um.asio.service.service.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface ArticleService {

	/**
	 * Find paginated.
	 *
	 * @param filter the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(ArticleFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();
}
