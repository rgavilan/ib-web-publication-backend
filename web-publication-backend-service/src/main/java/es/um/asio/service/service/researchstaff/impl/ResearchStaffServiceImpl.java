package es.um.asio.service.service.researchstaff.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.researchstaff.ResearchStaffFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.researchstaff.ResearchStaffService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class ResearchStaffServiceImpl extends FusekiService<ResearchStaffFilter> implements ResearchStaffService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ResearchStaffServiceImpl.class);
	
	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(ResearchStaffFilter filter, Pageable pageable) {
		logger.info("Searching research staff with filter: {} page: {}", filter, pageable);
		
		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(ResearchStaffFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		
		
		
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity() {
		Entity entity = new Entity("Person", "birthDate", "description", "firstName", "gender", "hasContactInfo", "homepage", "id", "image", "name", "nickname", 
				"personalMaibox", "researchLine", "surname", "taxId", "title");
		
		Map<String, Map<String, String>> join = new HashMap<>();
		
		join.put("Research-Group", new HashMap<>());
		join.get("Research-Group").put("x", "pers");
		
		entity.setJoin(join);
		
		return entity;
	}
}
