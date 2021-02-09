package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.BookSectionDto;
import es.um.asio.service.mapper.BookSectionMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class BookSectionMapperDecorator extends BaseMapperDecorator<BookSectionDto> implements BookSectionMapper {

	@Autowired
    @Qualifier("delegate")
	private BookSectionMapper mapper;
	
	public BookSectionMapperDecorator() {
		this.type = BookSectionDto.class;
	}
	
	@Override
	public BookSectionDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<BookSectionDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<BookSectionDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
