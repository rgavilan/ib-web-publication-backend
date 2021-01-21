package es.um.asio.back.controller.university;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.UniversityDto;
import es.um.asio.service.filter.university.UniversityFilter;
import es.um.asio.service.proxy.university.UniversityProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * University controller.
 */
@RestController
@RequestMapping(UniversityController.Mappings.BASE)
public class UniversityController {

	@Autowired
	private UniversityProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(UniversityController.Mappings.SEARCH)
	public Page<UniversityDto> searchProyects(final UniversityFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/university";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
