package es.um.asio.service.test.filters;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.filter.document.DocumentFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.service.document.DocumentService;

@RunWith(SpringRunner.class)
public class DocumentFilterTest {
	@MockBean
	DocumentService service;

	DocumentFilter filter;

	Pageable pageable;

	@Before
	public void beforeTest() {

		filter = new DocumentFilter();

		filter.setId("1");

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));
		FusekiResponse fuseki = new FusekiResponse();
		List<FusekiResponse> contentResult = new ArrayList<>();
		// Mock
		Mockito.when(this.service.findPaginated(filter, pageable)).thenAnswer(invocation -> {

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Document/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"52\" } ,\r\n"
					+ "        \"title\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"Title\" } ,\r\n"
					+ "        \"date\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"doi\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"endPage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"D\" }\r\n"
					+ "        \"publishedIn\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "        \"startPage\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" }\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

	}

	@Test
	public void test_documentFilter() {
		System.out.println(filter.toString());
		Page<FusekiResponse> page = service.findPaginated(filter, pageable);

		assertNotNull(page);

	}
}
