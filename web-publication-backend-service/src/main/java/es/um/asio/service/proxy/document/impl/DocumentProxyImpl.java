package es.um.asio.service.proxy.document.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.document.DocumentFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.document.DocumentProxy;
import es.um.asio.service.service.document.DocumentService;

/**
 * Implementación del Proxy para Documentos
 *
 */
@Service
public class DocumentProxyImpl implements DocumentProxy {

	@Autowired
	private DocumentService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(DocumentFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
