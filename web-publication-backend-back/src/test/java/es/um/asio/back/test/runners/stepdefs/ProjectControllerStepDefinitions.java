package es.um.asio.back.test.runners.stepdefs;

import static org.junit.Assert.assertNull;

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
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.proxy.project.ProjectProxy;
import es.um.asio.service.proxy.project.impl.ProjectProxyImpl;
import es.um.asio.service.service.project.ProjectService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = ProjectController.class)
public class ProjectControllerStepDefinitions {

	@Autowired
	@MockBean
	ProjectProxy proxy;

	@MockBean
	ProjectService service;

	ProjectFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class ProjectControllerStepDefinitionsConfiguration {
		@Bean
		public ProjectProxy projectProxy() {
			return new ProjectProxyImpl();
		}
	}

	@Before
	public void setup() throws Exception {

		// Mock StorageType proxy
		Mockito.when(this.proxy.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			String json = "{\r\n" + "  \"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"description\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n"
					+ "  } ,\r\n" + "  \"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Proyecto/c1cca9b3-6762-3e09-8aa3-ea860644ecd4\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"description\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"FP00-359\" } ,\r\n"
					+ "        \"ini\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"2012-01-27\" } ,\r\n"
					+ "        \"fin\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"15076\" } ,\r\n"
					+ "        \"tipo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"FP00\" }\r\n"
					+ "      }\r\n" + "    ]\r\n" + "  }\r\n" + "}";

			List<String> list = new ArrayList<>();
			list.add(json);
			Page<String> page = new PageImpl<>(list, pageable, list.size());
			return page;
		});

	}

	@Given("^call to backend project controller$")
	public void call_to_backend_project_controller() {
		filter = new ProjectFilter();
		filter.setName("NAME");
		filter.setLanguage("es");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));
	}

	@Then("^the controller call to servie and find result to send front$")
	public void the_controller_call_to_servie_and_find_result_to_send_front() {

		Page<String> page = this.proxy.findPaginated(filter, pageable);
		assertNull(page);
	}

}
