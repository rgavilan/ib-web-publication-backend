package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.AcademicPublicationDto;
import es.um.asio.service.mapper.AcademicPublicationMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class AcademicPublicationMapperDecorator extends BaseMapperDecorator<AcademicPublicationDto> implements AcademicPublicationMapper {

	@Autowired
    @Qualifier("delegate")
	private AcademicPublicationMapper mapper;
	
	public AcademicPublicationMapperDecorator() {
		this.type = AcademicPublicationDto.class;
	}
	
	@Override
	public AcademicPublicationDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<AcademicPublicationDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<AcademicPublicationDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
