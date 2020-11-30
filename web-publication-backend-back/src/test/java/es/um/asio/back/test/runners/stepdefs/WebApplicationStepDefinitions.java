package es.um.asio.back.test.runners.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import es.um.asio.back.controller.project.ProjectController;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.patent.PatentProxy;
import es.um.asio.service.proxy.patent.impl.PatentProxyImpl;
import es.um.asio.service.proxy.project.ProjectProxy;
import es.um.asio.service.proxy.project.impl.ProjectProxyImpl;
import es.um.asio.service.service.patent.PatentService;
import es.um.asio.service.service.project.ProjectService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ProjectController.class)
public class WebApplicationStepDefinitions {

	@Autowired
	@MockBean
	ProjectProxy proxyProject;

	@MockBean
	ProjectService serviceProject;

	ProjectFilter filterProject;

	Pageable pageableProject;

	@Autowired
	@MockBean
	PatentProxy proxyPatent;

	@MockBean
	PatentService servicePatent;

	PatentFilter filterPatent;

	Pageable pageablePatent;

	@TestConfiguration
	static class WebApplicationStepDefinitionsConfiguration {
		@Bean
		public ProjectProxy projectProxy() {
			return new ProjectProxyImpl();
		}

		@Bean
		public PatentProxy patentProxy() {
			return new PatentProxyImpl();
		}
	}

	@Before
	public void setUp() throws Exception {

		// PROJECT
		filterProject = new ProjectFilter();
		filterProject.setName("NAME");
		filterProject.setLanguage("es");

		pageableProject = PageRequest.of(1, 5, Sort.by("ASC"));
		// Mock StorageType proxy
		Mockito.when(this.proxyProject.findPaginated(filterProject, pageableProject)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();
			List<FusekiResponse> contentResult = new ArrayList<>();
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
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageableProject, contentResult.size());
			return page;
		});

		// PATENT
		filterPatent = new PatentFilter();
		filterPatent.setName("NAME");
		filterPatent.setLanguage("es");

		pageablePatent = PageRequest.of(1, 5, Sort.by("ASC"));
		// Mock StorageType proxy
		Mockito.when(this.proxyPatent.findPaginated(filterPatent, pageablePatent)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();

			List<FusekiResponse> contentResult = new ArrayList<>();

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Patente/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"ini\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"fin\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"tipo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"D\" }\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageablePatent, contentResult.size());
			return page;
		});

	}

	@Given("^call to backend project controller$")
	public void call_to_backend_project_controller() {
		assertNotNull(filterProject);
	}

	@Then("^the controller call to servie and find project result to send front$")
	public void the_controller_call_to_servie_and_find_project_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyProject.findPaginated(filterProject, pageableProject);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Given("^call to backend patent controller$")
	public void call_to_backend_patent_controller() {
		assertNotNull(filterPatent);
	}

	@Then("^the controller call to servie and find patent result to send front$")
	public void the_controller_call_to_servie_and_find_patent_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyPatent.findPaginated(filterPatent, pageablePatent);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}
}
