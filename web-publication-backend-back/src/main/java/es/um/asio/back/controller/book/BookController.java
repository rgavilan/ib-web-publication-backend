package es.um.asio.back.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.book.BookProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Book controller.
 */
@RestController
@RequestMapping(BookController.Mappings.BASE)
public class BookController {

	@Autowired
	private BookProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(BookController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final BookFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/book";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
