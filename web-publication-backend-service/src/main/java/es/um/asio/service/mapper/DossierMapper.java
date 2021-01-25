package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.DossierDto;
import es.um.asio.service.mapper.decorator.DossierMapperDecorator;

@Mapper
@DecoratedWith(DossierMapperDecorator.class)
public interface DossierMapper extends BaseMapper<DossierDto> {

}
