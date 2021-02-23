package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.PatentDto;
import es.um.asio.service.mapper.PatentMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class PatentMapperDecorator extends BaseMapperDecorator<PatentDto> implements PatentMapper {

	@Autowired
    @Qualifier("delegate")
	private PatentMapper mapper;
	
	public PatentMapperDecorator() {
		this.type = PatentDto.class;
	}
	
	@Override
	public PatentDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<PatentDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<PatentDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
