package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.BookChapterDto;
import es.um.asio.service.mapper.BookChapterMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class BookChapterMapperDecorator extends BaseMapperDecorator<BookChapterDto> implements BookChapterMapper {

	@Autowired
    @Qualifier("delegate")
	private BookChapterMapper mapper;
	
	public BookChapterMapperDecorator() {
		this.type = BookChapterDto.class;
	}
	
	@Override
	public BookChapterDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<BookChapterDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<BookChapterDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
