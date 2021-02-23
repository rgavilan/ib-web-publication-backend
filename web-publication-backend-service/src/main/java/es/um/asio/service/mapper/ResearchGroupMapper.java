package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ResearchGroupDto;
import es.um.asio.service.mapper.decorator.ResearchGroupMapperDecorator;

@Mapper
@DecoratedWith(ResearchGroupMapperDecorator.class)
public interface ResearchGroupMapper extends BaseMapper<ResearchGroupDto> {

}
