package es.um.asio.service.proxy.editorrole;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.EditorRoleDto;
import es.um.asio.service.filter.editorrole.EditorRoleFilter;

public interface EditorRoleProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<EditorRoleDto>
	 */
	Page<EditorRoleDto> findPaginated(EditorRoleFilter filter, Pageable pageable);
}
