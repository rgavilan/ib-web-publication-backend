package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ResearchGroupDto;
import es.um.asio.service.mapper.ResearchGroupMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ResearchGroupMapperDecorator extends BaseMapperDecorator<ResearchGroupDto> implements ResearchGroupMapper {

	@Autowired
    @Qualifier("delegate")
	private ResearchGroupMapper mapper;
	
	public ResearchGroupMapperDecorator() {
		this.type = ResearchGroupDto.class;
	}
	
	@Override
	public ResearchGroupDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ResearchGroupDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ResearchGroupDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
