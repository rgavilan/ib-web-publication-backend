package es.um.asio.service.proxy.fundingsource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.FundingSourceDto;
import es.um.asio.service.filter.fundingsource.FundingSourceFilter;

public interface FundingSourceProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<FundingSourceDto>
	 */
	Page<FundingSourceDto> findPaginated(FundingSourceFilter filter, Pageable pageable);
}
