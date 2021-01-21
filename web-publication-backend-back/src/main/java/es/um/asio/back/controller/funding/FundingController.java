package es.um.asio.back.controller.funding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.FundingDto;
import es.um.asio.service.filter.funding.FundingFilter;
import es.um.asio.service.proxy.funding.FundingProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Funding controller.
 */
@RestController
@RequestMapping(FundingController.Mappings.BASE)
public class FundingController {

	@Autowired
	private FundingProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(FundingController.Mappings.SEARCH)
	public Page<FundingDto> searchProyects(final FundingFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/Funding";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
