package es.um.asio.service.proxy.person.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.PersonDto;
import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.mapper.PersonMapper;
import es.um.asio.service.proxy.person.PersonProxy;
import es.um.asio.service.service.person.PersonService;

/**
 * Implementación del Proxy para Personas
 *
 */
@Service
public class PersonProxyImpl implements PersonProxy {

	@Autowired
	private PersonService service;
	
	@Autowired
	private PersonMapper mapper;
	
	@Override
	public Page<PersonDto> findPaginated(PersonFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}

}
