package es.um.asio.back.controller.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.invoice.InvoiceProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Invoice controller.
 */
@RestController
@RequestMapping(InvoiceController.Mappings.BASE)
public class InvoiceController {

	@Autowired
	private InvoiceProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(InvoiceController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final InvoiceFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/invoice";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
