package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.MasterThesisDto;
import es.um.asio.service.mapper.decorator.MasterThesisMapperDecorator;

@Mapper
@DecoratedWith(MasterThesisMapperDecorator.class)
public interface MasterThesisMapper extends BaseMapper<MasterThesisDto> {

}
