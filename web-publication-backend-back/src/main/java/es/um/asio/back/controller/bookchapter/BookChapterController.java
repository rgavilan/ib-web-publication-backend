package es.um.asio.back.controller.bookchapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.BookChapterDto;
import es.um.asio.service.filter.bookchapter.BookChapterFilter;
import es.um.asio.service.proxy.bookchapter.BookChapterProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * BookChapter controller.
 */
@RestController
@RequestMapping(BookChapterController.Mappings.BASE)
public class BookChapterController {

	@Autowired
	private BookChapterProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(BookChapterController.Mappings.SEARCH)
	public Page<BookChapterDto> searchProyects(final BookChapterFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/bookchapter";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
