package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.EditorRoleDto;
import es.um.asio.service.mapper.EditorRoleMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class EditorRoleMapperDecorator extends BaseMapperDecorator<EditorRoleDto> implements EditorRoleMapper {

	@Autowired
    @Qualifier("delegate")
	private EditorRoleMapper mapper;
	
	public EditorRoleMapperDecorator() {
		this.type = EditorRoleDto.class;
	}
	
	@Override
	public EditorRoleDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<EditorRoleDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<EditorRoleDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
