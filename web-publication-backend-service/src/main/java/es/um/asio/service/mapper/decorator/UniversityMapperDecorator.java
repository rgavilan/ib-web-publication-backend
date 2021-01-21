package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.UniversityDto;
import es.um.asio.service.mapper.UniversityMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class UniversityMapperDecorator extends BaseMapperDecorator<UniversityDto> implements UniversityMapper {

	@Autowired
    @Qualifier("delegate")
	private UniversityMapper mapper;
	
	public UniversityMapperDecorator() {
		this.type = UniversityDto.class;
	}
	
	@Override
	public UniversityDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<UniversityDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<UniversityDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
