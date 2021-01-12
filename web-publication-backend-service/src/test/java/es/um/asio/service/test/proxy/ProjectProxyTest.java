package es.um.asio.service.test.proxy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.model.PageableQuery;
import es.um.asio.service.proxy.project.ProjectProxy;
import es.um.asio.service.proxy.project.impl.ProjectProxyImpl;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.project.impl.ProjectServiceImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@RunWith(SpringRunner.class)
public class ProjectProxyTest {
	/**
	 * Project proxy
	 */
	@Autowired
	private ProjectProxy proxy;

	@Autowired
	private ProjectService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	ProjectFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class ProjectProxyTestConfiguration {
		@Bean
		public ProjectProxy projectProxy() {
			return new ProjectProxyImpl();
		}

		@Bean
		@Primary
		public ProjectService projectService() {
			return new ProjectServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new ProjectFilter();

		filter.setId("1");
		filter.setLanguage("es");
		filter.setName("Project Test");
		filter.setEnd("22/10/2020");
		filter.setFund("");
		filter.setStart("10/10/2020");
		filter.setTipo("C");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));
		FusekiResponse fuseki = new FusekiResponse();
		List<FusekiResponse> contentResult = new ArrayList<>();

		PageableQuery pageableQuery = new PageableQuery(service.retrieveEntity(), service.filtersChunk(filter),
				pageable);
		// Mock
		Mockito.when(this.serviceSPARQL.run(pageableQuery)).thenAnswer(invocation -> {

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Article/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"ini\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"fin\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"tipo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"D\" }\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});
	}

	@Test
	public void proxyTest() {
		proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
