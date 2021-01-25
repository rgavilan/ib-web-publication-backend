package es.um.asio.back.controller.doctoralthesis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.DoctoralThesisDto;
import es.um.asio.service.filter.doctoralthesis.DoctoralThesisFilter;
import es.um.asio.service.proxy.doctoralthesis.DoctoralThesisProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * PhDThesis controller.
 */
@RestController
@RequestMapping(DoctoralThesisController.Mappings.BASE)
public class DoctoralThesisController {

	@Autowired
	private DoctoralThesisProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(DoctoralThesisController.Mappings.SEARCH)
	public Page<DoctoralThesisDto> searchProyects(final DoctoralThesisFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/doctoralThesis";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
