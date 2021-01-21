package es.um.asio.back.controller.phdthesis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.PhDThesisDto;
import es.um.asio.service.filter.phdthesis.PhDThesisFilter;
import es.um.asio.service.proxy.phdthesis.PhDThesisProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * PhDThesis controller.
 */
@RestController
@RequestMapping(PhDThesisController.Mappings.BASE)
public class PhDThesisController {

	@Autowired
	private PhDThesisProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(PhDThesisController.Mappings.SEARCH)
	public Page<PhDThesisDto> searchProyects(final PhDThesisFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/PhDThesis";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
