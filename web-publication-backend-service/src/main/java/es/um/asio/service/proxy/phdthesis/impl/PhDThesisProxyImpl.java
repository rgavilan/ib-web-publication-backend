package es.um.asio.service.proxy.phdthesis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.PhDThesisDto;
import es.um.asio.service.filter.phdthesis.PhDThesisFilter;
import es.um.asio.service.mapper.PhDThesisMapper;
import es.um.asio.service.proxy.phdthesis.PhDThesisProxy;
import es.um.asio.service.service.phdthesis.PhDThesisService;

/**
 * Implementación del Proxy para PhDThesis
 *
 */
@Service
public class PhDThesisProxyImpl implements PhDThesisProxy {

	@Autowired
	private PhDThesisService service;
	
	@Autowired
	private PhDThesisMapper mapper;
	
	@Override
	public Page<PhDThesisDto> findPaginated(PhDThesisFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
