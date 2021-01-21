package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.mapper.ArticleMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ArticleMapperDecorator extends BaseMapperDecorator<ArticleDto> implements ArticleMapper {

	@Autowired
    @Qualifier("delegate")
	private ArticleMapper mapper;
	
	public ArticleMapperDecorator() {
		this.type = ArticleDto.class;
	}
	
	@Override
	public ArticleDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ArticleDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ArticleDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
