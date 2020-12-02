package es.um.asio.service.service.project.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.abstractions.constants.Constants;
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.sparql.SparqlExecQuery;
import es.um.asio.service.util.SparqlUtils;

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
			if (StringUtils.isNotBlank(filter.getDescription())) {
				strBuilder.append("FILTER (LANG(?description) = \"");
				strBuilder.append(filter.getDescription().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?name, \"");
				strBuilder.append(filter.getDescription());
				strBuilder.append("\", \"i\")) . ");
			}

			if (StringUtils.isNotBlank(filter.getFin())) {
				strBuilder.append(SparqlUtils.dateLE("fin", filter.getFin(), Constants.DATE_FORMAT_YYYY_MM_DD));
			}

			if (StringUtils.isNotBlank(filter.getId())) {
				strBuilder.append("FILTER (?id = \"");
				strBuilder.append(filter.getId());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}

			if (StringUtils.isNotBlank(filter.getIni())) {
				strBuilder.append(SparqlUtils.dateGE("ini", filter.getIni(), Constants.DATE_FORMAT_YYYY_MM_DD));
			}

			if (StringUtils.isNotBlank(filter.getName())) {
				strBuilder.append("FILTER (LANG(?name) = \"");
				strBuilder.append(filter.getLanguage().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?name, \"");
				strBuilder.append(filter.getName());
				strBuilder.append("\", \"i\")) . ");
			}

			if (StringUtils.isNotBlank(filter.getTipo())) {
				strBuilder.append("FILTER (?tipo = \"");
				strBuilder.append(filter.getTipo());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}

		}
		return strBuilder.toString();
	}

	public Entity retrieveEntity() {
		return new Entity("Proyecto", "end", "fund", "id", "name", "start", "tipo");
	}

}
