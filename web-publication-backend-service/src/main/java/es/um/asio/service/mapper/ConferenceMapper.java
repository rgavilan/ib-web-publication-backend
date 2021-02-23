package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ConferenceDto;
import es.um.asio.service.mapper.decorator.ConferenceMapperDecorator;

@Mapper
@DecoratedWith(ConferenceMapperDecorator.class)
public interface ConferenceMapper extends BaseMapper<ConferenceDto> {

}
