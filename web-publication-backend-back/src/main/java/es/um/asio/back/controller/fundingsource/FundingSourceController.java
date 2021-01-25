package es.um.asio.back.controller.fundingsource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.FundingSourceDto;
import es.um.asio.service.filter.fundingsource.FundingSourceFilter;
import es.um.asio.service.proxy.fundingsource.FundingSourceProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Funding controller.
 */
@RestController
@RequestMapping(FundingSourceController.Mappings.BASE)
public class FundingSourceController {

	@Autowired
	private FundingSourceProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(FundingSourceController.Mappings.SEARCH)
	public Page<FundingSourceDto> searchProyects(final FundingSourceFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/fundingSource";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
