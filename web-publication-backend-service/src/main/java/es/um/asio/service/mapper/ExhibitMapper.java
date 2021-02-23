package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ExhibitDto;
import es.um.asio.service.mapper.decorator.ExhibitMapperDecorator;

@Mapper
@DecoratedWith(ExhibitMapperDecorator.class)
public interface ExhibitMapper extends BaseMapper<ExhibitDto> {

}
