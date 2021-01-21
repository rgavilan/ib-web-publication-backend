package es.um.asio.back.controller.expo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ExpoDto;
import es.um.asio.service.filter.expo.ExpoFilter;
import es.um.asio.service.proxy.expo.ExpoProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Expo controller.
 */
@RestController
@RequestMapping(ExpoController.Mappings.BASE)
public class ExpoController {

	@Autowired
	private ExpoProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ExpoController.Mappings.SEARCH)
	public Page<ExpoDto> searchProyects(final ExpoFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/Expo";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
