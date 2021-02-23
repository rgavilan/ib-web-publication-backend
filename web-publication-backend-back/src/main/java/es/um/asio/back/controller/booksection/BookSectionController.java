package es.um.asio.back.controller.booksection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.BookSectionDto;
import es.um.asio.service.filter.booksection.BookSectionFilter;
import es.um.asio.service.proxy.booksection.BookSectionProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * BookSection controller.
 */
@RestController
@RequestMapping(BookSectionController.Mappings.BASE)
public class BookSectionController {

	@Autowired
	private BookSectionProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(BookSectionController.Mappings.SEARCH)
	public Page<BookSectionDto> searchProyects(final BookSectionFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/booksection";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
