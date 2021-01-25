package es.um.asio.service.service.document.impl;

import java.util.Arrays;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.document.DocumentFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.article.impl.ArticleServiceImpl;
import es.um.asio.service.service.document.DocumentService;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class DocumentServiceImpl extends FusekiService<DocumentFilter> implements DocumentService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(DocumentFilter filter, Pageable pageable) {
		logger.info("Searching documents with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(filter), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(DocumentFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (filter != null) {
			if (StringUtils.isNotBlank(filter.getDate())) {
				strBuilder.append("FILTER (?date = \"");
				strBuilder.append(filter.getDate());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getDoi())) {
				strBuilder.append("FILTER (?doi = \"");
				strBuilder.append(filter.getDoi());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getEndPage())) {
				strBuilder.append("FILTER (?endPage = \"");
				strBuilder.append(filter.getEndPage());
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
			
			if (StringUtils.isNotBlank(filter.getPublishedIn())) {
				strBuilder.append("FILTER (?publishedIn = \"");
				strBuilder.append(filter.getPublishedIn());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getStartPage())) {
				strBuilder.append("FILTER (?startPage = \"");
				strBuilder.append(filter.getStartPage());
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
			
			if (StringUtils.isNotBlank(filter.getDateFrom())) {
				strBuilder.append("FILTER (?date >= \"");
				strBuilder.append(filter.getDateFrom());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getDateTo())) {
				strBuilder.append("FILTER (?date <= \"");
				strBuilder.append(filter.getDateTo());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
		}
		
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity(DocumentFilter filter) {
		return new Entity("Documento", Arrays.asList(filter.getTypes().split(",")), "date", "doi", "endPage", "id", "publishedIn", "startPage", "title", "nowhere:type");
	}

	@Override
	public Entity retrieveEntity() {
		throw new NotImplementedException("retrieveEntity: Not implemented method");
	}
}
