package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.MasterThesisDto;
import es.um.asio.service.mapper.MasterThesisMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class MasterThesisMapperDecorator extends BaseMapperDecorator<MasterThesisDto> implements MasterThesisMapper {

	@Autowired
    @Qualifier("delegate")
	private MasterThesisMapper mapper;
	
	public MasterThesisMapperDecorator() {
		this.type = MasterThesisDto.class;
	}
	
	@Override
	public MasterThesisDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<MasterThesisDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<MasterThesisDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
