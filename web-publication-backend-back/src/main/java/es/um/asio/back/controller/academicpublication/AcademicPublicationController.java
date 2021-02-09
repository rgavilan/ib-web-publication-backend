package es.um.asio.back.controller.academicpublication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.AcademicPublicationDto;
import es.um.asio.service.filter.academicpublication.AcademicPublicationFilter;
import es.um.asio.service.proxy.academicpublication.AcademicPublicationProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * AcademicPublication controller.
 */
@RestController
@RequestMapping(AcademicPublicationController.Mappings.BASE)
public class AcademicPublicationController {

	@Autowired
	private AcademicPublicationProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(AcademicPublicationController.Mappings.SEARCH)
	public Page<AcademicPublicationDto> searchProyects(final AcademicPublicationFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/academicpublication";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
