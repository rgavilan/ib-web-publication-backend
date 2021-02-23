package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ConferenceDto;
import es.um.asio.service.mapper.ConferenceMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ConferenceMapperDecorator extends BaseMapperDecorator<ConferenceDto> implements ConferenceMapper {

	@Autowired
    @Qualifier("delegate")
	private ConferenceMapper mapper;
	
	public ConferenceMapperDecorator() {
		this.type = ConferenceDto.class;
	}
	
	@Override
	public ConferenceDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ConferenceDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ConferenceDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
