package es.um.asio.service.proxy.academicpublication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.AcademicPublicationDto;
import es.um.asio.service.filter.academicpublication.AcademicPublicationFilter;
import es.um.asio.service.mapper.AcademicPublicationMapper;
import es.um.asio.service.proxy.academicpublication.AcademicPublicationProxy;
import es.um.asio.service.service.academicpublication.AcademicPublicationService;

/**
 * Implementación del Proxy para AcademicPublication
 *
 */
@Service
public class AcademicPublicationProxyImpl implements AcademicPublicationProxy {

	@Autowired
	private AcademicPublicationService service;
	
	@Autowired
	private AcademicPublicationMapper mapper;
	
	@Override
	public Page<AcademicPublicationDto> findPaginated(AcademicPublicationFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
