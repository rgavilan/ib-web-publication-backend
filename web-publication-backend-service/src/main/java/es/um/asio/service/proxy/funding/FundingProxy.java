package es.um.asio.service.proxy.funding;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.FundingDto;
import es.um.asio.service.filter.funding.FundingFilter;

public interface FundingProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<FundingDto>
	 */
	Page<FundingDto> findPaginated(FundingFilter filter, Pageable pageable);
}
