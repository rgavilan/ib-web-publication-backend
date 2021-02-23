package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.AcademicPublicationDto;
import es.um.asio.service.mapper.decorator.AcademicPublicationMapperDecorator;

@Mapper
@DecoratedWith(AcademicPublicationMapperDecorator.class)
public interface AcademicPublicationMapper extends BaseMapper<AcademicPublicationDto> {

}
