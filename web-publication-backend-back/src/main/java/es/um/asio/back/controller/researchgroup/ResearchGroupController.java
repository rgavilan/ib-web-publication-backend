package es.um.asio.back.controller.researchgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ResearchGroupDto;
import es.um.asio.service.filter.researchgroup.ResearchGroupFilter;
import es.um.asio.service.proxy.researchgroup.ResearchGroupProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * InvestigationGroup controller.
 */
@RestController
@RequestMapping(ResearchGroupController.Mappings.BASE)
public class ResearchGroupController {

	@Autowired
	private ResearchGroupProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ResearchGroupController.Mappings.SEARCH)
	public Page<ResearchGroupDto> searchProyects(final ResearchGroupFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/researchGroup";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
