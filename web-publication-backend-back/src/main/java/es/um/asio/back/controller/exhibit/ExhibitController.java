package es.um.asio.back.controller.exhibit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ExhibitDto;
import es.um.asio.service.filter.exhibit.ExhibitFilter;
import es.um.asio.service.proxy.exhibit.ExhibitProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Expo controller.
 */
@RestController
@RequestMapping(ExhibitController.Mappings.BASE)
public class ExhibitController {

	@Autowired
	private ExhibitProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ExhibitController.Mappings.SEARCH)
	public Page<ExhibitDto> searchProyects(final ExhibitFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/exhibit";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
