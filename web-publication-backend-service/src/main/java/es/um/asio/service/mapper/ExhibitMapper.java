package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ExpoDto;
import es.um.asio.service.mapper.decorator.ExpoMapperDecorator;

@Mapper
@DecoratedWith(ExpoMapperDecorator.class)
public interface ExpoMapper extends BaseMapper<ExpoDto> {

}
