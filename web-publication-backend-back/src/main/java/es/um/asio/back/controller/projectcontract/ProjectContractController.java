package es.um.asio.back.controller.projectcontract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ProjectContractDto;
import es.um.asio.service.filter.projectcontract.ProjectContractFilter;
import es.um.asio.service.proxy.projectcontract.ProjectContractProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ProjectContract controller.
 */
@RestController
@RequestMapping(ProjectContractController.Mappings.BASE)
public class ProjectContractController {

	@Autowired
	private ProjectContractProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ProjectContractController.Mappings.SEARCH)
	public Page<ProjectContractDto> searchProyects(final ProjectContractFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/projectContract";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
