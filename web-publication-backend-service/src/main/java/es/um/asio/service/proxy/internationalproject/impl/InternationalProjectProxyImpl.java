package es.um.asio.service.proxy.internationalproject.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.InternationalProjectDto;
import es.um.asio.service.filter.internationalproject.InternationalProjectFilter;
import es.um.asio.service.mapper.InternationalProjectMapper;
import es.um.asio.service.proxy.internationalproject.InternationalProjectProxy;
import es.um.asio.service.service.internationalproject.InternationalProjectService;

/**
 * Implementación del Proxy para InternationalProject
 *
 */
@Service
public class InternationalProjectProxyImpl implements InternationalProjectProxy {
	
	@Autowired
	private InternationalProjectService service;
	
	@Autowired
	private InternationalProjectMapper mapper;
	
	@Override
	public Page<InternationalProjectDto> findPaginated(InternationalProjectFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
