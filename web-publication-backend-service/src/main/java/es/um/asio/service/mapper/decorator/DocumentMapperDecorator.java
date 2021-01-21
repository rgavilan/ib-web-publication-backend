package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.DocumentDto;
import es.um.asio.service.mapper.DocumentMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class DocumentMapperDecorator extends BaseMapperDecorator<DocumentDto> implements DocumentMapper {

	@Autowired
    @Qualifier("delegate")
	private DocumentMapper mapper;
	
	public DocumentMapperDecorator() {
		this.type = DocumentDto.class;
	}
	
	@Override
	public DocumentDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<DocumentDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<DocumentDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
