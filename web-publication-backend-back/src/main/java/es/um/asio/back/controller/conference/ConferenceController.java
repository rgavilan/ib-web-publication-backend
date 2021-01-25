package es.um.asio.back.controller.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ConferenceDto;
import es.um.asio.service.filter.conference.ConferenceFilter;
import es.um.asio.service.proxy.conference.ConferenceProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Congress controller.
 */
@RestController
@RequestMapping(ConferenceController.Mappings.BASE)
public class ConferenceController {

	@Autowired
	private ConferenceProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ConferenceController.Mappings.SEARCH)
	public Page<ConferenceDto> searchProyects(final ConferenceFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/conference";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
