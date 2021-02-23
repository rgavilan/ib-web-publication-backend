package es.um.asio.service.proxy.researchaccreditation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ResearchAccreditationDto;
import es.um.asio.service.filter.researchaccreditation.ResearchAccreditationFilter;
import es.um.asio.service.mapper.ResearchAccreditationMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.researchaccreditation.ResearchAccreditationProxy;
import es.um.asio.service.service.researchaccreditation.ResearchAccreditationService;

/**
 * Implementación del Proxy para ResearchAccreditation
 *
 */
@Service
public class ResearchAccreditationProxyImpl implements ResearchAccreditationProxy {

	@Autowired
	private ResearchAccreditationService service;
	
	@Autowired
	private ResearchAccreditationMapper mapper;
	
	@Override
	public Page<ResearchAccreditationDto> findPaginated(ResearchAccreditationFilter filter, Pageable pageable) {
		Page<FusekiResponse> result = this.service.findPaginated(filter, pageable);
		
		return this.mapper.convertPageFusekiResponseToDto(result);
	}
}
