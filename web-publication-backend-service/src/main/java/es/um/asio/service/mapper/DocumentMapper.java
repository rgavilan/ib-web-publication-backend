package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.DocumentDto;
import es.um.asio.service.mapper.decorator.DocumentMapperDecorator;

@Mapper
@DecoratedWith(DocumentMapperDecorator.class)
public interface DocumentMapper extends BaseMapper<DocumentDto> {

}
