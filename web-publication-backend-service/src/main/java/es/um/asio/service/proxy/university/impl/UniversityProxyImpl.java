package es.um.asio.service.proxy.university.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.university.UniversityFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.university.UniversityProxy;
import es.um.asio.service.service.university.UniversityService;

/**
 * Implementación del Proxy para Universidades
 *
 */
@Service
public class UniversityProxyImpl implements UniversityProxy {

	@Autowired
	private UniversityService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(UniversityFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
