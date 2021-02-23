package es.um.asio.service.proxy.projectexpense.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ProjectExpenseDto;
import es.um.asio.service.filter.projectexpense.ProjectExpenseFilter;
import es.um.asio.service.mapper.ProjectExpenseMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.projectexpense.ProjectExpenseProxy;
import es.um.asio.service.service.projectexpense.ProjectExpenseService;

/**
 * Implementación del Proxy para ProjectExpense
 *
 */
@Service
public class ProjectExpenseProxyImpl implements ProjectExpenseProxy {

	@Autowired
	private ProjectExpenseService service;
	
	@Autowired
	private ProjectExpenseMapper mapper;
	
	@Override
	public Page<ProjectExpenseDto> findPaginated(ProjectExpenseFilter filter, Pageable pageable) {
		Page<FusekiResponse> result = this.service.findPaginated(filter, pageable);
		
		return this.mapper.convertPageFusekiResponseToDto(result);
	}
}
