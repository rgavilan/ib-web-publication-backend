package es.um.asio.service.service.authorarticle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.authorarticle.AuthorArticleFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface AuthorArticleService {

	/**
	 * Find paginated.
	 *
	 * @param filter the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(AuthorArticleFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();
}
