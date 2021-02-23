package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.DoctoralThesisDto;
import es.um.asio.service.mapper.decorator.DoctoralThesisMapperDecorator;

@Mapper
@DecoratedWith(DoctoralThesisMapperDecorator.class)
public interface DoctoralThesisMapper extends BaseMapper<DoctoralThesisDto> {

}
