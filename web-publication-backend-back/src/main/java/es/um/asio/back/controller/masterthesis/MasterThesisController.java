package es.um.asio.back.controller.masterthesis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.MasterThesisDto;
import es.um.asio.service.filter.masterthesis.MasterThesisFilter;
import es.um.asio.service.proxy.masterthesis.MasterThesisProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * MasterThesis controller.
 */
@RestController
@RequestMapping(MasterThesisController.Mappings.BASE)
public class MasterThesisController {

	@Autowired
	private MasterThesisProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(MasterThesisController.Mappings.SEARCH)
	public Page<MasterThesisDto> searchProyects(final MasterThesisFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/masterThesis";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
