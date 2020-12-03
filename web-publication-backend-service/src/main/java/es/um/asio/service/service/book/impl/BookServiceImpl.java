package es.um.asio.service.service.book.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.article.impl.ArticleServiceImpl;
import es.um.asio.service.service.book.BookService;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class BookServiceImpl extends FusekiService<BookFilter> implements BookService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(BookFilter filter, Pageable pageable) {
		logger.info("Searching books with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(BookFilter filter) {
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
		return new Entity("Libro", "anyo", "coautoria", "id", "name");
	}

}
