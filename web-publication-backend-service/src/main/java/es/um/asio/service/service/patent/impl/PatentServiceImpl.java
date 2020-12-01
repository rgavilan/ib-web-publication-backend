package es.um.asio.service.service.patent.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.abstractions.constants.Constants;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.patent.PatentService;
import es.um.asio.service.service.sparql.SparqlExecQuery;
import es.um.asio.service.util.SparqlUtils;

@Service
public class PatentServiceImpl implements PatentService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(PatentServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;

	@Override
	public Page<FusekiResponse> findPaginated(PatentFilter filter, Pageable pageable) {
		logger.info("Searching patents with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public Entity retrieveEntity() {
		return new Entity("Patente", "fin", "id", "ini", "name", "tipo");
	}

	public String filtersChunk(PatentFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		if (filter != null) {

			if (StringUtils.isNotBlank(filter.getFin())) {
				strBuilder.append(SparqlUtils.dateLE("fin", filter.getFin(), Constants.DATE_FORMAT_DD_MM_YYYY));
			}

			if (StringUtils.isNotBlank(filter.getId())) {
				strBuilder.append("FILTER (?id = \"");
				strBuilder.append(filter.getId());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}

			if (StringUtils.isNotBlank(filter.getIni())) {
				strBuilder.append(SparqlUtils.dateGE("ini", filter.getIni(), Constants.DATE_FORMAT_DD_MM_YYYY));
			}

			if (StringUtils.isNotBlank(filter.getName())) {
				// En SPARQL, la función regex no admite el idioma.
				// Es necesario hacer un filtro previo que compruebe el idioma.
				// Importante eliminar el @ del idioma.
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

}
