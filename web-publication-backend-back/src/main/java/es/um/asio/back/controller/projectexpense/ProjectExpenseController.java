package es.um.asio.back.controller.projectexpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.ProjectExpenseDto;
import es.um.asio.service.filter.projectexpense.ProjectExpenseFilter;
import es.um.asio.service.proxy.projectexpense.ProjectExpenseProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ProjectExpense controller.
 */
@RestController
@RequestMapping(ProjectExpenseController.Mappings.BASE)
public class ProjectExpenseController {

	@Autowired
	private ProjectExpenseProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(ProjectExpenseController.Mappings.SEARCH)
	public Page<ProjectExpenseDto> searchProyects(final ProjectExpenseFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/projectExpense";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
