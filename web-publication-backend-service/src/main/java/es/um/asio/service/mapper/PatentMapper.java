package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.PatentDto;
import es.um.asio.service.mapper.decorator.PatentMapperDecorator;

@Mapper
@DecoratedWith(PatentMapperDecorator.class)
public interface PatentMapper extends BaseMapper<PatentDto> {

}
