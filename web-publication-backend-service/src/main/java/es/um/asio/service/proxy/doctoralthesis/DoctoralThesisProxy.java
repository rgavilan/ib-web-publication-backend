package es.um.asio.service.proxy.doctoralthesis;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.um.asio.service.dto.DoctoralThesisDto;
import es.um.asio.service.filter.doctoralthesis.DoctoralThesisFilter;

public interface DoctoralThesisProxy {

	/**
	 * Método de búsqueda
	 * 
	 * @param filter
	 * @param pageable
	 * @return Page<DoctoralThesisDto>
	 */
	Page<DoctoralThesisDto> findPaginated(DoctoralThesisFilter filter, Pageable pageable);
}
