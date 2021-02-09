package es.um.asio.service.proxy.projectcontract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ProjectContractDto;
import es.um.asio.service.filter.projectcontract.ProjectContractFilter;

public interface ProjectContractProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ProjectContractDto>
	 */
	Page<ProjectContractDto> findPaginated(ProjectContractFilter filter, Pageable pageable);
}
