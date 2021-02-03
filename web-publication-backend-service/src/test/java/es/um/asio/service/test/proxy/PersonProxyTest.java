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

import es.um.asio.service.dto.PersonDto;
import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.mapper.PersonMapper;
import es.um.asio.service.mapper.decorator.PersonMapperDecorator;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.person.PersonProxy;
import es.um.asio.service.proxy.person.impl.PersonProxyImpl;
import es.um.asio.service.service.person.PersonService;
import es.um.asio.service.service.person.impl.PersonServiceImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@RunWith(SpringRunner.class)
public class PersonProxyTest {

	/**
	 * Person proxy
	 */
	@Autowired
	private PersonProxy proxy;
	
	@Autowired
	private PersonMapper mapper;

	@Autowired
	private PersonService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	PersonFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class PersonProxyTestConfiguration {
		@Bean
		public PersonProxy personProxy() {
			return new PersonProxyImpl();
		}
		
		@Bean
		public PersonMapper personMapper() {
			return new PersonMapperDecorator();
		}

		@Bean
		@Primary
		public PersonService personService() {
			return new PersonServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new PersonFilter();

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
					+ "        \"title\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"TITLE\" } ,\r\n"
					+ "        \"birthDate\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"description\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"firstName\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "        \"gender\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"hasContactInfo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"homepage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"image\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"nickname\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"personalMailBox\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"researchLine\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"surname\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"taxId\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
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
		Page<PersonDto> page = proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
