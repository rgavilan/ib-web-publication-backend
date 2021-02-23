package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.InternationalProjectDto;
import es.um.asio.service.mapper.InternationalProjectMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class InternationalProjectMapperDecorator extends BaseMapperDecorator<InternationalProjectDto> implements InternationalProjectMapper {

	@Autowired
    @Qualifier("delegate")
	private InternationalProjectMapper mapper;
	
	public InternationalProjectMapperDecorator() {
		this.type = InternationalProjectDto.class;
	}
	
	@Override
	public InternationalProjectDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<InternationalProjectDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<InternationalProjectDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
