package es.um.asio.service.service.dossier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.dossier.DossierFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;

public interface DossierService {

	/**
	 * Find paginated.
	 *
	 * @param filter   the filter
	 * @param pageable the pageable
	 * @return the page
	 */
	Page<FusekiResponse> findPaginated(DossierFilter filter, Pageable pageable);

	/**
	 * Retrieve entity.
	 *
	 * @return the entity
	 */
	Entity retrieveEntity();

	String filtersChunk(DossierFilter filter);
}
