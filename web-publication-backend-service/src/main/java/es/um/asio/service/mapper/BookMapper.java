package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.BookDto;
import es.um.asio.service.mapper.decorator.BookMapperDecorator;

@Mapper
@DecoratedWith(BookMapperDecorator.class)
public interface BookMapper extends BaseMapper<BookDto> {

}
