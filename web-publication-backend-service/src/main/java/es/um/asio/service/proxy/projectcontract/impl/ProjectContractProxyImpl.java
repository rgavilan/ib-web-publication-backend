package es.um.asio.service.proxy.projectcontract.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ProjectContractDto;
import es.um.asio.service.filter.projectcontract.ProjectContractFilter;
import es.um.asio.service.mapper.ProjectContractMapper;
import es.um.asio.service.proxy.projectcontract.ProjectContractProxy;
import es.um.asio.service.service.projectcontract.ProjectContractService;

/**
 * Implementación del Proxy para ProjectContract
 *
 */
@Service
public class ProjectContractProxyImpl implements ProjectContractProxy {

	@Autowired
	private ProjectContractService service;
	
	@Autowired
	private ProjectContractMapper mapper;
	
	@Override
	public Page<ProjectContractDto> findPaginated(ProjectContractFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
