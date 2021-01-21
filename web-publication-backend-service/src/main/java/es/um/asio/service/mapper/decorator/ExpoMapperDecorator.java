package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ExpoDto;
import es.um.asio.service.mapper.ExpoMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ExpoMapperDecorator extends BaseMapperDecorator<ExpoDto> implements ExpoMapper {

	@Autowired
    @Qualifier("delegate")
	private ExpoMapper mapper;
	
	public ExpoMapperDecorator() {
		this.type = ExpoDto.class;
	}
	
	@Override
	public ExpoDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ExpoDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ExpoDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
