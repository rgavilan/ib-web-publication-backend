package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.DoctoralThesisDto;
import es.um.asio.service.mapper.DoctoralThesisMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class DoctoralThesisMapperDecorator extends BaseMapperDecorator<DoctoralThesisDto> implements DoctoralThesisMapper {

	@Autowired
    @Qualifier("delegate")
	private DoctoralThesisMapper mapper;
	
	public DoctoralThesisMapperDecorator() {
		this.type = DoctoralThesisDto.class;
	}
	
	@Override
	public DoctoralThesisDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<DoctoralThesisDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<DoctoralThesisDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
