package es.um.asio.service.service.researchgroup.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.researchgroup.ResearchGroupFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.researchgroup.ResearchGroupService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class ResearchGroupServiceImpl extends FusekiService<ResearchGroupFilter> implements ResearchGroupService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ResearchGroupServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(ResearchGroupFilter filter, Pageable pageable) {
		logger.info("Searching research groups with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(ResearchGroupFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (filter != null) {
			if (StringUtils.isNotBlank(filter.getAbbreviation())) {
				strBuilder.append("FILTER (?abbreviation = \"");
				strBuilder.append(filter.getAbbreviation());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getDescription())) {
				strBuilder.append("FILTER (?description = \"");
				strBuilder.append(filter.getDescription());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getEndDate())) {
				strBuilder.append("FILTER (?endDate = \"");
				strBuilder.append(filter.getEndDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getExcellenceLabel())) {
				strBuilder.append("FILTER (?excellenceLabel = \"");
				strBuilder.append(filter.getExcellenceLabel());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getHomepage())) {
				strBuilder.append("FILTER (?homepage = \"");
				strBuilder.append(filter.getHomepage());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getId())) {
				strBuilder.append("FILTER (?id = \"");
				strBuilder.append(filter.getId());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getStartDate())) {
				strBuilder.append("FILTER (?startDate = \"");
				strBuilder.append(filter.getStartDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getTitle())) {
				strBuilder.append("FILTER (LANG(?title) = \"");
				strBuilder.append(filter.getLanguage().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?title, \"");
				strBuilder.append(filter.getTitle());
				strBuilder.append("\", \"i\")) . ");
			}
		}
		
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity() {
		return new Entity("GrupoInvestigacion", "abbreviation", "description", "endDate", "excellenceLabel", "homepage", "id", "startDate", "topic");
	}

}
