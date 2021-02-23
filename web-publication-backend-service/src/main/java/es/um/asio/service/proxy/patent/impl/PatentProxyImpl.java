package es.um.asio.service.proxy.patent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.PatentDto;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.mapper.PatentMapper;
import es.um.asio.service.proxy.patent.PatentProxy;
import es.um.asio.service.service.patent.PatentService;

/**
 * Implementación del Proxy para Patentes
 *
 */
@Service
public class PatentProxyImpl implements PatentProxy {

	@Autowired
	private PatentService service;
	
	@Autowired
	private PatentMapper mapper;

	@Override
	public Page<PatentDto> findPaginated(PatentFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}

}
