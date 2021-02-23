package es.um.asio.service.proxy.funding.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.FundingDto;
import es.um.asio.service.filter.funding.FundingFilter;
import es.um.asio.service.mapper.FundingMapper;
import es.um.asio.service.proxy.funding.FundingProxy;
import es.um.asio.service.service.funding.FundingService;

/**
 * Implementación del Proxy para Funding
 *
 */
@Service
public class FundingProxyImpl implements FundingProxy {

	@Autowired
	private FundingService service;
	
	@Autowired
	private FundingMapper mapper;
	
	@Override
	public Page<FundingDto> findPaginated(FundingFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
