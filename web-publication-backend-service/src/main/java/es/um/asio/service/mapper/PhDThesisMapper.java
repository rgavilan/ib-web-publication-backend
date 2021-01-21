package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.PhDThesisDto;
import es.um.asio.service.mapper.decorator.PhDThesisMapperDecorator;

@Mapper
@DecoratedWith(PhDThesisMapperDecorator.class)
public interface PhDThesisMapper extends BaseMapper<PhDThesisDto> {

}
