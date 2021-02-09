package es.um.asio.service.proxy.organization.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.OrganizationDto;
import es.um.asio.service.filter.organization.OrganizationFilter;
import es.um.asio.service.mapper.OrganizationMapper;
import es.um.asio.service.proxy.organization.OrganizationProxy;
import es.um.asio.service.service.organization.OrganizationService;

/**
 * Implementación del Proxy para Organization
 *
 */
@Service
public class OrganizationProxyImpl implements OrganizationProxy {

	@Autowired
	private OrganizationService service;
	
	@Autowired
	private OrganizationMapper mapper;
	
	@Override
	public Page<OrganizationDto> findPaginated(OrganizationFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
