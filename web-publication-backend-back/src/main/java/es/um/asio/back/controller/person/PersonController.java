package es.um.asio.back.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.person.PersonProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Person controller.
 */
@RestController
@RequestMapping(PersonController.Mappings.BASE)
public class PersonController {

	@Autowired
	private PersonProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(PersonController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final PersonFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/person";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
