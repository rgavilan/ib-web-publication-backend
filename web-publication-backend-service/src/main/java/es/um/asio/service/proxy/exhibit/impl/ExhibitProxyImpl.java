package es.um.asio.service.proxy.exhibit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ExhibitDto;
import es.um.asio.service.filter.exhibit.ExhibitFilter;
import es.um.asio.service.mapper.ExhibitMapper;
import es.um.asio.service.proxy.exhibit.ExhibitProxy;
import es.um.asio.service.service.exhibit.ExhibitService;

/**
 * Implementación del Proxy para Expo
 *
 */
@Service
public class ExhibitProxyImpl implements ExhibitProxy {

	@Autowired
	private ExhibitService service;
	
	@Autowired
	private ExhibitMapper mapper;
	
	@Override
	public Page<ExhibitDto> findPaginated(ExhibitFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
