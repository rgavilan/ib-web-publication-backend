package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.UniversityDto;
import es.um.asio.service.mapper.decorator.UniversityMapperDecorator;

@Mapper
@DecoratedWith(UniversityMapperDecorator.class)
public interface UniversityMapper extends BaseMapper<UniversityDto> {

}
