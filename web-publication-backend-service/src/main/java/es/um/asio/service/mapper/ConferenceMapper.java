package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.CongressDto;
import es.um.asio.service.mapper.decorator.CongressMapperDecorator;

@Mapper
@DecoratedWith(CongressMapperDecorator.class)
public interface CongressMapper extends BaseMapper<CongressDto> {

}
