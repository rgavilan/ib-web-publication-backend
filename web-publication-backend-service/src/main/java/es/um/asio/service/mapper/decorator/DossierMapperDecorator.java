package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.DossierDto;
import es.um.asio.service.mapper.DossierMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class DossierMapperDecorator extends BaseMapperDecorator<DossierDto> implements DossierMapper {

	@Autowired
    @Qualifier("delegate")
	private DossierMapper mapper;
	
	public DossierMapperDecorator() {
		this.type = DossierDto.class;
	}
	
	@Override
	public DossierDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<DossierDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<DossierDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
