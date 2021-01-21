package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.FundingDto;
import es.um.asio.service.mapper.decorator.FundingMapperDecorator;

@Mapper
@DecoratedWith(FundingMapperDecorator.class)
public interface FundingMapper extends BaseMapper<FundingDto> {

}
