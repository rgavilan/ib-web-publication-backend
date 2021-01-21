package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.PhDThesisDto;
import es.um.asio.service.mapper.PhDThesisMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class PhDThesisMapperDecorator extends BaseMapperDecorator<PhDThesisDto> implements PhDThesisMapper {

	@Autowired
    @Qualifier("delegate")
	private PhDThesisMapper mapper;
	
	public PhDThesisMapperDecorator() {
		this.type = PhDThesisDto.class;
	}
	
	@Override
	public PhDThesisDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<PhDThesisDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<PhDThesisDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
