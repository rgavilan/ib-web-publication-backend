package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.OrganizationDto;
import es.um.asio.service.mapper.OrganizationMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class OrganizationMapperDecorator extends BaseMapperDecorator<OrganizationDto> implements OrganizationMapper {

	@Autowired
    @Qualifier("delegate")
	private OrganizationMapper mapper;
	
	public OrganizationMapperDecorator() {
		this.type = OrganizationDto.class;
	}
	
	@Override
	public OrganizationDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<OrganizationDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<OrganizationDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
