package es.um.asio.back.controller.researchaccreditation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ResearchAccreditationDto;
import es.um.asio.service.filter.researchaccreditation.ResearchAccreditationFilter;
import es.um.asio.service.proxy.researchaccreditation.ResearchAccreditationProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ResearchAccreditation controller.
 */
@RestController
@RequestMapping(ResearchAccreditationController.Mappings.BASE)
public class ResearchAccreditationController {

	@Autowired
	private ResearchAccreditationProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ResearchAccreditationController.Mappings.SEARCH)
	public Page<ResearchAccreditationDto> searchProyects(final ResearchAccreditationFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/researchAccreditation";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
