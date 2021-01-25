package es.um.asio.service.service.researchaccreditation;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.researchaccreditation.ResearchAccreditationFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface ResearchAccreditationService {

	/**
	 * Find paginated.
	 *
	 * @param filter   the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(ResearchAccreditationFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();

	String filtersChunk(ResearchAccreditationFilter filter);
}
