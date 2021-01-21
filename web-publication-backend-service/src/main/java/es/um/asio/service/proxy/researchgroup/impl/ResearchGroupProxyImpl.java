package es.um.asio.service.proxy.researchgroup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ResearchGroupDto;
import es.um.asio.service.filter.researchgroup.ResearchGroupFilter;
import es.um.asio.service.mapper.ResearchGroupMapper;
import es.um.asio.service.proxy.researchgroup.ResearchGroupProxy;
import es.um.asio.service.service.researchgroup.ResearchGroupService;

/**
 * Implementación del Proxy para Grupos Investigacion
 *
 */
@Service
public class ResearchGroupProxyImpl implements ResearchGroupProxy {

	@Autowired
	private ResearchGroupService service;
	
	@Autowired
	private ResearchGroupMapper mapper;
	
	@Override
	public Page<ResearchGroupDto> findPaginated(ResearchGroupFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}

}
