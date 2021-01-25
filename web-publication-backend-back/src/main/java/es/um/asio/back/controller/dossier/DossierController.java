package es.um.asio.back.controller.dossier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.DossierDto;
import es.um.asio.service.filter.dossier.DossierFilter;
import es.um.asio.service.proxy.dossier.DossierProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Dossier controller.
 */
@RestController
@RequestMapping(DossierController.Mappings.BASE)
public class DossierController {

	@Autowired
	private DossierProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(DossierController.Mappings.SEARCH)
	public Page<DossierDto> searchProyects(final DossierFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/dossier";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
