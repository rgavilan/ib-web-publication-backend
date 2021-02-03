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

import es.um.asio.service.dto.InvoiceDto;
import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.mapper.InvoiceMapper;
import es.um.asio.service.mapper.decorator.InvoiceMapperDecorator;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.invoice.InvoiceProxy;
import es.um.asio.service.proxy.invoice.impl.InvoiceProxyImpl;
import es.um.asio.service.service.invoice.InvoiceService;
import es.um.asio.service.service.invoice.impl.InvoiceServiceImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@RunWith(SpringRunner.class)
public class InvoiceProxyTest {
	/**
	 * Invoice proxy
	 */
	@Autowired
	private InvoiceProxy proxy;
	
	@Autowired
	private InvoiceMapper mapper;

	@Autowired
	private InvoiceService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	InvoiceFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class InvoiceProxyTestConfiguration {
		@Bean
		public InvoiceProxy invoiceProxy() {
			return new InvoiceProxyImpl();
		}
		
		@Bean
		public InvoiceMapper invoiceMapper() {
			return new InvoiceMapperDecorator();
		}

		@Bean
		@Primary
		public InvoiceService invoiceService() {
			return new InvoiceServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new InvoiceFilter();

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
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Invoice/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"title\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"TITLE\" } ,\r\n"
					+ "        \"dateTime\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"doi\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"endPage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "        \"keyword\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"publishedIn\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
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
		Page<InvoiceDto> page = proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
