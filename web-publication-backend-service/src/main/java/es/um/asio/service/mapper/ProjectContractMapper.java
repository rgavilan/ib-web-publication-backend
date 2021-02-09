package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ProjectContractDto;
import es.um.asio.service.mapper.decorator.ProjectContractMapperDecorator;

@Mapper
@DecoratedWith(ProjectContractMapperDecorator.class)
public interface ProjectContractMapper extends BaseMapper<ProjectContractDto> {

}
