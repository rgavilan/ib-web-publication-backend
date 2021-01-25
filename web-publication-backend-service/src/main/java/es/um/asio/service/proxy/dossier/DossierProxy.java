package es.um.asio.service.proxy.dossier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.DossierDto;
import es.um.asio.service.filter.dossier.DossierFilter;

public interface DossierProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<DossierDto>
	 */
	Page<DossierDto> findPaginated(DossierFilter filter, Pageable pageable);
}
