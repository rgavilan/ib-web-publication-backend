package es.um.asio.service.service.project.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class ProjectServiceImpl extends FusekiService<ProjectFilter> implements ProjectService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;

	@Override
	public Page<FusekiResponse> findPaginated(ProjectFilter filter, Pageable pageable) {
		logger.info("Searching projects with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);

	}

	public String filtersChunk(ProjectFilter filter) {
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
				strBuilder.append(filter.getStartDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getForeseenJustificationDate())) {
				strBuilder.append("FILTER (?foreseenJustificationDate = \"");
				strBuilder.append(filter.getForeseenJustificationDate());
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
			
			if (StringUtils.isNotBlank(filter.getKeyword())) {
				strBuilder.append("FILTER (?keyword = \"");
				strBuilder.append(filter.getKeyword());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getModality())) {
				strBuilder.append("FILTER (?modality = \"");
				strBuilder.append(filter.getModality());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getNeedsEthicalValidation())) {
				strBuilder.append("FILTER (?needsEthicalValidation = \"");
				strBuilder.append(filter.getNeedsEthicalValidation());
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
			
			if (StringUtils.isNotBlank(filter.getStatus())) {
				strBuilder.append("FILTER (?status = \"");
				strBuilder.append(filter.getStatus());
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

	public Entity retrieveEntity() {
		return new Entity("Project", "abbreviation", "description", "endDate", "foreseenJustificationDate", "id", "keyword", "modality", 
				"needsEthicalValidation", "startDate", "status", "title");
	}

}
