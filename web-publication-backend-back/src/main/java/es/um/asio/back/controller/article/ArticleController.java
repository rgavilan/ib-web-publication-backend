package es.um.asio.back.controller.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.proxy.article.ArticleProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Article controller.
 */
@RestController
@RequestMapping(ArticleController.Mappings.BASE)
public class ArticleController {

	@Autowired
	private ArticleProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ArticleController.Mappings.SEARCH)
	public Page<ArticleDto> searchProyects(final ArticleFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/article";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
