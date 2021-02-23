package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.InvoiceDto;
import es.um.asio.service.mapper.InvoiceMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class InvoiceMapperDecorator extends BaseMapperDecorator<InvoiceDto> implements InvoiceMapper {

	@Autowired
    @Qualifier("delegate")
	private InvoiceMapper mapper;
	
	public InvoiceMapperDecorator() {
		this.type = InvoiceDto.class;
	}
	
	@Override
	public InvoiceDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<InvoiceDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<InvoiceDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
