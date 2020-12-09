package es.um.asio.back.controller.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.document.DocumentFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.document.DocumentProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Article controller.
 */
@RestController
@RequestMapping(DocumentController.Mappings.BASE)
public class DocumentController {

	@Autowired
	private DocumentProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(DocumentController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final DocumentFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/document";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
