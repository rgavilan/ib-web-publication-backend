package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.mapper.decorator.ArticleMapperDecorator;

@Mapper
@DecoratedWith(ArticleMapperDecorator.class)
public interface ArticleMapper extends BaseMapper<ArticleDto> {
	
}
