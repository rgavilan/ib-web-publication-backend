package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.ProjectExpenseDto;
import es.um.asio.service.mapper.decorator.ProjectExpenseMapperDecorator;

@Mapper
@DecoratedWith(ProjectExpenseMapperDecorator.class)
public interface ProjectExpenseMapper extends BaseMapper<ProjectExpenseDto> {

}
