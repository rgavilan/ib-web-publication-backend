package es.um.asio.back.controller.investigationgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.investigationgroup.InvestigationGroupFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.investigationgroup.InvestigationGroupProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * InvestigationGroup controller.
 */
@RestController
@RequestMapping(InvestigationGroupController.Mappings.BASE)
public class InvestigationGroupController {

	@Autowired
	private InvestigationGroupProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(InvestigationGroupController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final InvestigationGroupFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/investigationgroup";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
