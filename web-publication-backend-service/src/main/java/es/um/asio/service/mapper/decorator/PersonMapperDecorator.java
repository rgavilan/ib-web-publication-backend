package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.PersonDto;
import es.um.asio.service.mapper.PersonMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class PersonMapperDecorator extends BaseMapperDecorator<PersonDto> implements PersonMapper {

	@Autowired
    @Qualifier("delegate")
	private PersonMapper mapper;
	
	public PersonMapperDecorator() {
		this.type = PersonDto.class;
	}
	
	@Override
	public PersonDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<PersonDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<PersonDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
