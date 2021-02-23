package es.um.asio.service.proxy.doctoralthesis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.DoctoralThesisDto;
import es.um.asio.service.filter.doctoralthesis.DoctoralThesisFilter;
import es.um.asio.service.mapper.DoctoralThesisMapper;
import es.um.asio.service.proxy.doctoralthesis.DoctoralThesisProxy;
import es.um.asio.service.service.doctoralthesis.DoctoralThesisService;

/**
 * Implementación del Proxy para PhDThesis
 *
 */
@Service
public class DoctoralThesisProxyImpl implements DoctoralThesisProxy {

	@Autowired
	private DoctoralThesisService service;
	
	@Autowired
	private DoctoralThesisMapper mapper;
	
	@Override
	public Page<DoctoralThesisDto> findPaginated(DoctoralThesisFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
