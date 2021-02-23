package es.um.asio.service.service.academicpublication;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.academicpublication.AcademicPublicationFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface AcademicPublicationService {

	/**
	 * Find paginated.
	 *
	 * @param filter   the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(AcademicPublicationFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @param filter the filter
	 * @return the entity
	 */
	Entity retrieveEntity(AcademicPublicationFilter filter);

	String filtersChunk(AcademicPublicationFilter filter);
}
