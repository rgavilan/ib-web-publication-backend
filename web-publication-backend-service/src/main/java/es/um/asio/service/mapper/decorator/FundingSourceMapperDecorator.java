package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.FundingSourceDto;
import es.um.asio.service.mapper.FundingSourceMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class FundingSourceMapperDecorator extends BaseMapperDecorator<FundingSourceDto> implements FundingSourceMapper {

	@Autowired
    @Qualifier("delegate")
	private FundingSourceMapper mapper;
	
	public FundingSourceMapperDecorator() {
		this.type = FundingSourceDto.class;
	}
	
	@Override
	public FundingSourceDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<FundingSourceDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<FundingSourceDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
