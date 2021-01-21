package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.CongressDto;
import es.um.asio.service.mapper.CongressMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class CongressMapperDecorator extends BaseMapperDecorator<CongressDto> implements CongressMapper {

	@Autowired
    @Qualifier("delegate")
	private CongressMapper mapper;
	
	public CongressMapperDecorator() {
		this.type = CongressDto.class;
	}
	
	@Override
	public CongressDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<CongressDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<CongressDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
