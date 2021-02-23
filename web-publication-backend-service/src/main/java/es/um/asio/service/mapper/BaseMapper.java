package es.um.asio.service.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public interface BaseMapper<T> {
	
	T convertFusekiObjectToDto(Object object);
	
	List<T> convertFusekiResponseToDto(List<Object> response);

	PageImplHelper<T> convertPageFusekiResponseToDto(Page<FusekiResponse> page);
}
