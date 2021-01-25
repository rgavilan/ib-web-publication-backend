package es.um.asio.service.proxy.congress.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.CongressDto;
import es.um.asio.service.filter.congress.CongressFilter;
import es.um.asio.service.mapper.CongressMapper;
import es.um.asio.service.proxy.congress.CongressProxy;
import es.um.asio.service.service.congress.CongressService;

/**
 * Implementación del Proxy para Congress
 *
 */
@Service
public class CongressProxyImpl implements CongressProxy {

	@Autowired
	private CongressService service;
	
	@Autowired
	private CongressMapper mapper;
	
	@Override
	public Page<CongressDto> findPaginated(CongressFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
