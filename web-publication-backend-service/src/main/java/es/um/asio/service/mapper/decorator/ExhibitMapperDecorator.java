package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ExhibitDto;
import es.um.asio.service.mapper.ExhibitMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ExhibitMapperDecorator extends BaseMapperDecorator<ExhibitDto> implements ExhibitMapper {

	@Autowired
    @Qualifier("delegate")
	private ExhibitMapper mapper;
	
	public ExhibitMapperDecorator() {
		this.type = ExhibitDto.class;
	}
	
	@Override
	public ExhibitDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ExhibitDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ExhibitDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
