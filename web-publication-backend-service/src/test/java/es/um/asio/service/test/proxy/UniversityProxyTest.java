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

import es.um.asio.service.dto.UniversityDto;
import es.um.asio.service.filter.university.UniversityFilter;
import es.um.asio.service.mapper.UniversityMapper;
import es.um.asio.service.mapper.decorator.UniversityMapperDecorator;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.university.UniversityProxy;
import es.um.asio.service.proxy.university.impl.UniversityProxyImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;
import es.um.asio.service.service.university.UniversityService;
import es.um.asio.service.service.university.impl.UniversityServiceImpl;

@RunWith(SpringRunner.class)
public class UniversityProxyTest {
	/**
	 * University proxy
	 */
	@Autowired
	private UniversityProxy proxy;
	
	@Autowired
	private UniversityMapper mapper;

	@Autowired
	private UniversityService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	UniversityFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class UniversityProxyTestConfiguration {
		@Bean
		public UniversityProxy universityProxy() {
			return new UniversityProxyImpl();
		}
		
		@Bean
		public UniversityMapper universityMapper() {
			return new UniversityMapperDecorator();
		}

		@Bean
		@Primary
		public UniversityService universityService() {
			return new UniversityServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new UniversityFilter();

		filter.setId("1");
		filter.setLanguage("es");
		filter.setName("University Test");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));
		FusekiResponse fuseki = new FusekiResponse();
		List<FusekiResponse> contentResult = new ArrayList<>();
		// Mock
		Mockito.when(this.service.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/University/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			
			return this.mapper.convertPageFusekiResponseToDto(page);
		});
	}

	@Test
	public void proxyTest() {
		Page<UniversityDto> page = proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
