package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.EditorRoleDto;
import es.um.asio.service.mapper.decorator.EditorRoleMapperDecorator;

@Mapper
@DecoratedWith(EditorRoleMapperDecorator.class)
public interface EditorRoleMapper extends BaseMapper<EditorRoleDto> {

}
