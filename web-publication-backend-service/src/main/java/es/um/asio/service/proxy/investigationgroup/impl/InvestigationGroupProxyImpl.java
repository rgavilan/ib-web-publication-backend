package es.um.asio.service.proxy.investigationgroup.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.investigationgroup.InvestigationGroupFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.investigationgroup.InvestigationGroupProxy;
import es.um.asio.service.service.investigationgroup.InvestigationGroupService;

/**
 * Implementación del Proxy para Grupos Investigacion
 *
 */
@Service
public class InvestigationGroupProxyImpl implements InvestigationGroupProxy {

	@Autowired
	private InvestigationGroupService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(InvestigationGroupFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
