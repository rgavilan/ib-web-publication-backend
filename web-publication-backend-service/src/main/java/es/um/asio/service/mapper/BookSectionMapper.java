package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.BookSectionDto;
import es.um.asio.service.mapper.decorator.BookSectionMapperDecorator;

@Mapper
@DecoratedWith(BookSectionMapperDecorator.class)
public interface BookSectionMapper extends BaseMapper<BookSectionDto> {

}
