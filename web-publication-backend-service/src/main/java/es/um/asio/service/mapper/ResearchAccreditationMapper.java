package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ResearchAccreditationDto;
import es.um.asio.service.mapper.decorator.ResearchAccreditationMapperDecorator;

@Mapper
@DecoratedWith(ResearchAccreditationMapperDecorator.class)
public interface ResearchAccreditationMapper extends BaseMapper<ResearchAccreditationDto> {

}
