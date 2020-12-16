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
	private ProjectService projectService;

	ProjectFilter filter;

	Pageable pageable;

	@Before
	public void beforeTest() {

		filter = new ProjectFilter();
		filter.setName("NAME");
		filter.setLanguage("es");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));

		FusekiResponse fuseki = new FusekiResponse();
		List<FusekiResponse> contentResult = new ArrayList<>();
		// Mock
		Mockito.when(this.projectService.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			String head = "{\r\n" + "  \"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"description\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n"
					+ "  } ,\r\n";
			String result = "  \"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Proyecto/c1cca9b3-6762-3e09-8aa3-ea860644ecd4\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"description\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"FP00-359\" } ,\r\n"
					+ "        \"ini\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"2012-01-27\" } ,\r\n"
					+ "        \"fin\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"15076\" } ,\r\n"
					+ "        \"tipo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"FP00\" }\r\n"
					+ "      }\r\n" + "    ]\r\n" + "  }\r\n" + "}";
			;

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

		Mockito.when(projectService.retrieveEntity()).thenAnswer(invocation -> {
			Entity entity = new Entity("Proyecto", "description", "fin", "id", "ini", "name", "tipo");
			return entity;
		});
	}

	@Test
	public void testEntity() {

		Entity entity = new Entity("Proyecto", "description", "fin", "id", "ini", "name", "tipo");
		Entity entityFromService = projectService.retrieveEntity();
		assertThat(entityFromService).isEqualTo(entity);
	}

	@Test
	public void testfindPatent() {
		Page<FusekiResponse> page = this.projectService.findPaginated(filter, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}
}
