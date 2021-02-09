package es.um.asio.back.controller.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.OrganizationDto;
import es.um.asio.service.filter.organization.OrganizationFilter;
import es.um.asio.service.proxy.organization.OrganizationProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Organization controller.
 */
@RestController
@RequestMapping(OrganizationController.Mappings.BASE)
public class OrganizationController {

	@Autowired
	private OrganizationProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(OrganizationController.Mappings.SEARCH)
	public Page<OrganizationDto> searchProyects(final OrganizationFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/organization";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
