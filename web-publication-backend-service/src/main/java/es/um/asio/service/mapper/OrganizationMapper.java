package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.OrganizationDto;
import es.um.asio.service.mapper.decorator.OrganizationMapperDecorator;

@Mapper
@DecoratedWith(OrganizationMapperDecorator.class)
public interface OrganizationMapper extends BaseMapper<OrganizationDto> {

}
