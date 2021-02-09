package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ProjectContractDto;
import es.um.asio.service.mapper.ProjectContractMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ProjectContractMapperDecorator extends BaseMapperDecorator<ProjectContractDto> implements ProjectContractMapper {

	@Autowired
    @Qualifier("delegate")
	private ProjectContractMapper mapper;
	
	public ProjectContractMapperDecorator() {
		this.type = ProjectContractDto.class;
	}
	
	@Override
	public ProjectContractDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ProjectContractDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ProjectContractDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
