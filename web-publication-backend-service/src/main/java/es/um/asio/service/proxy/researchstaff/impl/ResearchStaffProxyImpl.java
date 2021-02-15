package es.um.asio.service.proxy.researchstaff.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.PersonDto;
import es.um.asio.service.filter.researchstaff.ResearchStaffFilter;
import es.um.asio.service.mapper.PersonMapper;
import es.um.asio.service.proxy.researchstaff.ResearchStaffProxy;
import es.um.asio.service.service.researchstaff.ResearchStaffService;

/**
 * Implementación del Proxy para ResearchStaff
 *
 */
@Service
public class ResearchStaffProxyImpl implements ResearchStaffProxy {

	@Autowired
	private ResearchStaffService service;
	
	@Autowired
	private PersonMapper mapper;
	
	@Override
	public Page<PersonDto> findPaginated(ResearchStaffFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}

}
