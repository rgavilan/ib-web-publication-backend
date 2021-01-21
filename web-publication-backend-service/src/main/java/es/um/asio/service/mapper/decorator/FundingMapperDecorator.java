package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.FundingDto;
import es.um.asio.service.mapper.FundingMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class FundingMapperDecorator extends BaseMapperDecorator<FundingDto> implements FundingMapper {

	@Autowired
    @Qualifier("delegate")
	private FundingMapper mapper;
	
	public FundingMapperDecorator() {
		this.type = FundingDto.class;
	}
	
	@Override
	public FundingDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<FundingDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<FundingDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
