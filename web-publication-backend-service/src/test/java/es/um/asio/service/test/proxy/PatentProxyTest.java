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

import es.um.asio.service.dto.PatentDto;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.mapper.PatentMapper;
import es.um.asio.service.mapper.decorator.PatentMapperDecorator;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.patent.PatentProxy;
import es.um.asio.service.proxy.patent.impl.PatentProxyImpl;
import es.um.asio.service.service.patent.PatentService;
import es.um.asio.service.service.patent.impl.PatentServiceImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@RunWith(SpringRunner.class)
public class PatentProxyTest {
	/**
	 * Patent proxy
	 */
	@Autowired
	private PatentProxy proxy;
	
	@Autowired
	private PatentMapper mapper;

	@Autowired
	private PatentService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	PatentFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class PatentProxyTestConfiguration {
		@Bean
		public PatentProxy patentProxy() {
			return new PatentProxyImpl();
		}
		
		@Bean
		public PatentMapper patentMapper() {
			return new PatentMapperDecorator();
		}

		@Bean
		@Primary
		public PatentService patentService() {
			return new PatentServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new PatentFilter();

		filter.setId("1");
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
					+ "        \"dateIssued\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"doi\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"endDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "        \"endPage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"keyword\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"mode\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"startDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"startPage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
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
		Page<PatentDto> page = proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
