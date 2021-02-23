package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ProjectDto;
import es.um.asio.service.mapper.decorator.ProjectMapperDecorator;

@Mapper
@DecoratedWith(ProjectMapperDecorator.class)
public interface ProjectMapper extends BaseMapper<ProjectDto> {

}
