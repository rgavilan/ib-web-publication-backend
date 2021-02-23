package es.um.asio.service.service.person.impl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.service.impl.FusekiService;
import es.um.asio.service.service.person.PersonService;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@Service
public class PersonServiceImpl extends FusekiService<PersonFilter> implements PersonService {

	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private SparqlExecQuery serviceSPARQL;
	
	@Override
	public Page<FusekiResponse> findPaginated(PersonFilter filter, Pageable pageable) {
		logger.info("Searching persons with filter: {} page: {}", filter, pageable);

		PageableQuery pageableQuery = new PageableQuery(this.retrieveEntity(), filtersChunk(filter), pageable);

		return serviceSPARQL.run(pageableQuery);
	}

	@Override
	public String filtersChunk(PersonFilter filter) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (filter != null) {
			if (StringUtils.isNotBlank(filter.getBirthDate())) {
				strBuilder.append("FILTER (?birthDate = \"");
				strBuilder.append(filter.getBirthDate());
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
			
			if (StringUtils.isNotBlank(filter.getFirstName())) {
				strBuilder.append("FILTER (?firstName = \"");
				strBuilder.append(filter.getFirstName());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getGender())) {
				strBuilder.append("FILTER (?gender = \"");
				strBuilder.append(filter.getGender());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getHasContactInfo())) {
				strBuilder.append("FILTER (?hasContactInfo = \"");
				strBuilder.append(filter.getHasContactInfo());
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
			
			if (StringUtils.isNotBlank(filter.getImage())) {
				strBuilder.append("FILTER (?image = \"");
				strBuilder.append(filter.getImage());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getName())) {
				strBuilder.append("FILTER (?name = \"");
				strBuilder.append(filter.getName());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getNickname())) {
				strBuilder.append("FILTER (?nickname = \"");
				strBuilder.append(filter.getNickname());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getPersonalMaibox())) {
				strBuilder.append("FILTER (?personalMaibox = \"");
				strBuilder.append(filter.getPersonalMaibox());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getResearchLine())) {
				strBuilder.append("FILTER (?researchLine = \"");
				strBuilder.append(filter.getResearchLine());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getSurname())) {
				strBuilder.append("FILTER (?surname = \"");
				strBuilder.append(filter.getSurname());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getTaxId())) {
				strBuilder.append("FILTER (?taxId = \"");
				strBuilder.append(filter.getTaxId());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
			
			if (StringUtils.isNotBlank(filter.getTitle())) {
				strBuilder.append("FILTER (?title = \"");
				strBuilder.append(filter.getTitle());
				strBuilder.append("\"");
				strBuilder.append(filter.getLanguage());
				strBuilder.append(") . ");
			}
		}
		
		return strBuilder.toString();
	}

	@Override
	public Entity retrieveEntity() {
		return new Entity("Person", "birthDate", "description", "firstName", "gender", "hasContactInfo", "homepage", "id", "image", "name", "nickname", 
				"personalMailBox", "researchLine", "surname", "taxId", "title");
	}

}
