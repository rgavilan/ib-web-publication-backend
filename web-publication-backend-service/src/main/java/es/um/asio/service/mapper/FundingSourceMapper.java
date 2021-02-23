package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.FundingSourceDto;
import es.um.asio.service.mapper.decorator.FundingSourceMapperDecorator;

@Mapper
@DecoratedWith(FundingSourceMapperDecorator.class)
public interface FundingSourceMapper extends BaseMapper<FundingSourceDto> {

}
