package es.um.asio.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

import es.um.asio.service.dto.InvoiceDto;
import es.um.asio.service.mapper.decorator.InvoiceMapperDecorator;

@Mapper
@DecoratedWith(InvoiceMapperDecorator.class)
public interface InvoiceMapper extends BaseMapper<InvoiceDto> {

}
