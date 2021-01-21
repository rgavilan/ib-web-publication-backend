package es.um.asio.back.controller.congress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.CongressDto;
import es.um.asio.service.filter.congress.CongressFilter;
import es.um.asio.service.proxy.congress.CongressProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Congress controller.
 */
@RestController
@RequestMapping(CongressController.Mappings.BASE)
public class CongressController {

	@Autowired
	private CongressProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(CongressController.Mappings.SEARCH)
	public Page<CongressDto> searchProyects(final CongressFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/Congress";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
