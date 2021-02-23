package es.um.asio.service.test.service.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.ServiceConfig;
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.service.project.ProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ServiceConfig.class })
public class ProjectServiceTest {

	@Autowired
	@MockBean
	private ProjectService service;

	ProjectFilter filter;

	Pageable pageable;

	@Before
	public void beforeTest() {

		filter = new ProjectFilter();
		filter.setId("52");
		filter.setLanguage("es");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));

		FusekiResponse fuseki = new FusekiResponse();
		List<FusekiResponse> contentResult = new ArrayList<>();
		// Mock
		Mockito.when(this.service.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Person/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"title\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"abbreviation\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"description\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"endDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "        \"foreseenJustificationDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"keyword\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"modality\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"needsEthicalValidation\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"startDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"status\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

		Mockito.when(this.service.retrieveEntity()).thenAnswer(invocation -> {
			Entity entity = new Entity("Project", "abbreviation", "description", "endDate", "foreseenJustificationDate", "id", "keyword", "modality", 
					"needsEthicalValidation", "startDate", "status", "title");
			return entity;
		});
	}

	@Test
	public void testEntity() {

		Entity entity = new Entity("Project", "abbreviation", "description", "endDate", "foreseenJustificationDate", "id", "keyword", "modality", 
				"needsEthicalValidation", "startDate", "status", "title");
		Entity entityFromService = this.service.retrieveEntity();
		assertThat(entityFromService).isEqualTo(entity);
	}

	@Test
	public void testfindPatent() {
		Page<FusekiResponse> page = this.service.findPaginated(filter, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("52"));
	}
}
