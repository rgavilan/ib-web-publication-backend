package es.um.asio.service.proxy.investigationgroup;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.filter.investigationgroup.InvestigationGroupFilter;
import es.um.asio.service.model.FusekiResponse;

public interface InvestigationGroupProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return ProjectDto
	 */
	Page<FusekiResponse> findPaginated(InvestigationGroupFilter filter, Pageable pageable);
}
