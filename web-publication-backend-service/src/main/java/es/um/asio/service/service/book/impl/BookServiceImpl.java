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
import es.um.asio.service.service.book.BookService;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class BookServiceImpl extends FusekiService<BookFilter> implements BookService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

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
			
			if (StringUtils.isNotBlank(filter.getEdition())) {
				strBuilder.append("FILTER (?edition = \"");
				strBuilder.append(filter.getEdition());
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
			
			if (StringUtils.isNotBlank(filter.getIccn())) {
				strBuilder.append("FILTER (?iccn = \"");
				strBuilder.append(filter.getIccn());
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
			
			if (StringUtils.isNotBlank(filter.getPlaceOfPublication())) {
				strBuilder.append("FILTER (?placeOfPublication = \"");
				strBuilder.append(filter.getPlaceOfPublication());
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
			
			if (StringUtils.isNotBlank(filter.getSummary())) {
				strBuilder.append("FILTER (LANG(?summary) = \"");
				strBuilder.append(filter.getLanguage().substring(1));
				strBuilder.append("\") . ");
				strBuilder.append("FILTER ( regex(?summary, \"");
				strBuilder.append(filter.getSummary());
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
	public Entity retrieveEntity() {
		return new Entity("Book", "date", "doi", "edition", "endPage", "iccn", "id", "placeOfPublication", "publishedIn", "startPage", "summary", "title");
	}

}
