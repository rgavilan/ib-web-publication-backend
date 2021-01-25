package es.um.asio.service.proxy.conference.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ConferenceDto;
import es.um.asio.service.filter.conference.ConferenceFilter;
import es.um.asio.service.mapper.ConferenceMapper;
import es.um.asio.service.proxy.conference.ConferenceProxy;
import es.um.asio.service.service.conference.ConferenceService;

/**
 * Implementación del Proxy para Congress
 *
 */
@Service
public class ConferenceProxyImpl implements ConferenceProxy {

	@Autowired
	private ConferenceService service;
	
	@Autowired
	private ConferenceMapper mapper;
	
	@Override
	public Page<ConferenceDto> findPaginated(ConferenceFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
