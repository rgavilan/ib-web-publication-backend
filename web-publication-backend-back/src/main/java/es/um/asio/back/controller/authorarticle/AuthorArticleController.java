package es.um.asio.back.controller.authorarticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.filter.authorarticle.AuthorArticleFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.authorarticle.AuthorArticleProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * AuthorArticle controller.
 */
@RestController
@RequestMapping(AuthorArticleController.Mappings.BASE)
public class AuthorArticleController {

	@Autowired
	private AuthorArticleProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(AuthorArticleController.Mappings.SEARCH)
	public Page<FusekiResponse> searchProyects(final AuthorArticleFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/authorarticle";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
