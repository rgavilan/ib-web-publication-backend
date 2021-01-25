package es.um.asio.back.controller.internationalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.InternationalProjectDto;
import es.um.asio.service.filter.internationalproject.InternationalProjectFilter;
import es.um.asio.service.proxy.internationalproject.InternationalProjectProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * InternationalProject controller.
 */
@RestController
@RequestMapping(InternationalProjectController.Mappings.BASE)
public class InternationalProjectController {

	@Autowired
	private InternationalProjectProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(InternationalProjectController.Mappings.SEARCH)
	public Page<InternationalProjectDto> searchProyects(final InternationalProjectFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/internationalProject";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
