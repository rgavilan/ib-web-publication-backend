package es.um.asio.service.proxy.invoice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.invoice.InvoiceProxy;
import es.um.asio.service.service.invoice.InvoiceService;

/**
 * Implementación del Proxy para Facturas
 *
 */
@Service
public class InvoiceProxyImpl implements InvoiceProxy {

	@Autowired
	private InvoiceService service;
	
	@Override
	public Page<FusekiResponse> findPaginated(InvoiceFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);
	}

}
