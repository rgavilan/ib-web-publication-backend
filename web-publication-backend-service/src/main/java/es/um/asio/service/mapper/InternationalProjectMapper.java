package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.InternationalProjectDto;
import es.um.asio.service.mapper.decorator.InternationalProjectMapperDecorator;

@Mapper
@DecoratedWith(InternationalProjectMapperDecorator.class)
public interface InternationalProjectMapper extends BaseMapper<InternationalProjectDto> {

}
