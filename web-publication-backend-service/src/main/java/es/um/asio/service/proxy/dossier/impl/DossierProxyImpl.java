package es.um.asio.service.proxy.dossier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.DossierDto;
import es.um.asio.service.filter.dossier.DossierFilter;
import es.um.asio.service.mapper.DossierMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.dossier.DossierProxy;
import es.um.asio.service.service.dossier.DossierService;

/**
 * Implementación del Proxy para Dossier
 *
 */
@Service
public class DossierProxyImpl implements DossierProxy {

	@Autowired
	private DossierService service;
	
	@Autowired
	private DossierMapper mapper;
	
	@Override
	public Page<DossierDto> findPaginated(DossierFilter filter, Pageable pageable) {
		Page<FusekiResponse> result = this.service.findPaginated(filter, pageable);
		
		return this.mapper.convertPageFusekiResponseToDto(result);
	}
}
