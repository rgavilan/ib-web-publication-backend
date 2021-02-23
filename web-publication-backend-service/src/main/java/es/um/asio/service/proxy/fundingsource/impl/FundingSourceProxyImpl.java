package es.um.asio.service.proxy.fundingsource.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.FundingSourceDto;
import es.um.asio.service.filter.fundingsource.FundingSourceFilter;
import es.um.asio.service.mapper.FundingSourceMapper;
import es.um.asio.service.proxy.fundingsource.FundingSourceProxy;
import es.um.asio.service.service.fundingsource.FundingSourceService;

/**
 * Implementación del Proxy para FundingSource
 *
 */
@Service
public class FundingSourceProxyImpl implements FundingSourceProxy {

	@Autowired
	private FundingSourceService service;
	
	@Autowired
	private FundingSourceMapper mapper;
	
	@Override
	public Page<FundingSourceDto> findPaginated(FundingSourceFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
