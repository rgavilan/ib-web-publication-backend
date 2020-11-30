package es.um.asio.back.test.controller.security;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.um.asio.back.controller.project.ProjectController;
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.proxy.project.ProjectProxy;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
@ActiveProfiles("unit-test")
public class ProjectControllerTest {

	@MockBean
	private ProjectProxy projectProxy;

	@Autowired
	private MockMvc mvc;

	@Before
	public void beforeTest() {

		ProjectFilter filter = new ProjectFilter();
		filter.setName("NAME");
		filter.setLanguage("es");

		Pageable pageable = PageRequest.of(1, 5, Sort.by("ASC"));
		// Mock StorageType proxy
		Mockito.when(this.projectProxy.findPaginated(filter, pageable)).thenAnswer(invocation -> {

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

	@Test
	public void test_Infraestructure() {
		assertNotNull(mvc);
	}

	@Test
	public void process() {

		try {
			this.mvc.perform(get("/project/search").content("").contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
		} catch (Exception e) {
			System.out.print("ERROR: " + e.getCause());
		}

	}

}
