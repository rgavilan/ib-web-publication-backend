package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.BookChapterDto;
import es.um.asio.service.mapper.decorator.BookChapterMapperDecorator;

@Mapper
@DecoratedWith(BookChapterMapperDecorator.class)
public interface BookChapterMapper extends BaseMapper<BookChapterDto> {

}
