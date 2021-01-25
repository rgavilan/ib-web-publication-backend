package es.um.asio.service.service.projectexpense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.projectexpense.ProjectExpenseFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface ProjectExpenseService {

	/**
	 * Find paginated.
	 *
	 * @param filter   the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(ProjectExpenseFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();

	String filtersChunk(ProjectExpenseFilter filter);
}
