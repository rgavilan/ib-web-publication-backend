package es.um.asio.back.controller.editorrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.um.asio.service.dto.EditorRoleDto;
import es.um.asio.service.filter.editorrole.EditorRoleFilter;
import es.um.asio.service.proxy.editorrole.EditorRoleProxy;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * EditorRole controller.
 */
@RestController
@RequestMapping(EditorRoleController.Mappings.BASE)
public class EditorRoleController {

	@Autowired
	private EditorRoleProxy proxy;
	
	@Value("${app.fusekitrellis.url}")
	private String fusekiTrellisUrl;


	@GetMapping(EditorRoleController.Mappings.SEARCH)
	public Page<EditorRoleDto> searchProyects(final EditorRoleFilter filter, final Pageable pageable) {
		return this.proxy.findPaginated(filter, pageable);
	}
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	static final class Mappings {
		/**
		 * Controller request mapping.
		 */
		protected static final String BASE = "/editorRole";

		/**
		 * Mapping for search.
		 */
		protected static final String SEARCH = "/search";
	}
}
