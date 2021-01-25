package es.um.asio.service.proxy.projectexpense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.ProjectExpenseDto;
import es.um.asio.service.filter.projectexpense.ProjectExpenseFilter;

public interface ProjectExpenseProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<ProjectExpenseDto>
	 */
	Page<ProjectExpenseDto> findPaginated(ProjectExpenseFilter filter, Pageable pageable);
}
