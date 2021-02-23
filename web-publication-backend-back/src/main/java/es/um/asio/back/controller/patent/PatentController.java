package es.um.asio.back.controller.patent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.PatentDto;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.proxy.patent.PatentProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Patent controller.
 */
@RestController
@RequestMapping(PatentController.Mappings.BASE)
public class PatentController {

	@Autowired
	private PatentProxy proxy;

	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;

	@GetMapping(PatentController.Mappings.SEARCH)
	public Page<PatentDto> searchProyects(final PatentFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/patent";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}

}
