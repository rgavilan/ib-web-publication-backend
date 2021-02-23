package es.um.asio.service.mapper.decorator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;

import es.um.asio.service.dto.ProjectExpenseDto;
import es.um.asio.service.mapper.ProjectExpenseMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class ProjectExpenseMapperDecorator extends BaseMapperDecorator<ProjectExpenseDto> implements ProjectExpenseMapper {

	@Autowired
    @Qualifier("delegate")
	private ProjectExpenseMapper mapper;
	
	public ProjectExpenseMapperDecorator() {
		this.type = ProjectExpenseDto.class;
	}
	
	@Override
	public ProjectExpenseDto convertFusekiObjectToDto(Object response) {
		return super.convertFusekiObjectToDto(response);
	}

	@Override
	public List<ProjectExpenseDto> convertFusekiResponseToDto(List<Object> response) {
		return super.convertFusekiResponseToDto(response);
	}

	@Override
	public PageImplHelper<ProjectExpenseDto> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		return super.convertPageFusekiResponseToDto(page);
	}
}
