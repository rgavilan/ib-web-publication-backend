package es.um.asio.service.service.article.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.article.ArticleService;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class ArticleServiceImpl extends FusekiService<ArticleFilter> implements ArticleService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(ArticleFilter filter, Pageable pageable) {
		logger.info("Searching articles with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(ArticleFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (filter != null) {
			if (StringUtils.isNotBlank(filter.getCoautoria())) {
				strBuilder.append("FILTER (?coautoria = \"");
				strBuilder.append(filter.getCoautoria());
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

			if (StringUtils.isNotBlank(filter.getName())) {
				strBuilder.append("FILTER (LANG(?name) = \"");
				strBuilder.append(filter.getLanguage().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?name, \"");
				strBuilder.append(filter.getName());
				strBuilder.append("\", \"i\")) . ");
			}
			
			if (StringUtils.isNotBlank(filter.getAnyo())) {
				strBuilder.append("FILTER (?anyo = \"");
				strBuilder.append(filter.getAnyo());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
		}
		
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity() {
		return new Entity("Articulo", "anyo", "coautoria", "id", "name");
	}

}
