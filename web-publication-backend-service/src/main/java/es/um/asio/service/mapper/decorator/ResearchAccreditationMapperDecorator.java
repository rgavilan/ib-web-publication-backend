package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ResearchAccreditationDto;
import es.um.asio.service.mapper.ResearchAccreditationMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ResearchAccreditationMapperDecorator extends BaseMapperDecorator<ResearchAccreditationDto> implements ResearchAccreditationMapper {

	@Autowired
    @Qualifier("delegate")
	private ResearchAccreditationMapper mapper;
	
	public ResearchAccreditationMapperDecorator() {
		this.type = ResearchAccreditationDto.class;
	}
	
	@Override
	public ResearchAccreditationDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ResearchAccreditationDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ResearchAccreditationDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
