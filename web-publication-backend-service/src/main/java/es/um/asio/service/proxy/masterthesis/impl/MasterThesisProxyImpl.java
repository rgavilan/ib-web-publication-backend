package es.um.asio.service.proxy.masterthesis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.MasterThesisDto;
import es.um.asio.service.filter.masterthesis.MasterThesisFilter;
import es.um.asio.service.mapper.MasterThesisMapper;
import es.um.asio.service.proxy.masterthesis.MasterThesisProxy;
import es.um.asio.service.service.masterthesis.MasterThesisService;

/**
 * Implementación del Proxy para MasterThesis
 *
 */
@Service
public class MasterThesisProxyImpl implements MasterThesisProxy {

	@Autowired
	private MasterThesisService service;
	
	@Autowired
	private MasterThesisMapper mapper;
	
	@Override
	public Page<MasterThesisDto> findPaginated(MasterThesisFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
