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

import es.um.asio.service.dto.ArticleDto;
import es.um.asio.service.filter.article.ArticleFilter;
import es.um.asio.service.mapper.ArticleMapper;
import es.um.asio.service.mapper.decorator.ArticleMapperDecorator;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.article.ArticleProxy;
import es.um.asio.service.proxy.article.impl.ArticleProxyImpl;
import es.um.asio.service.service.article.ArticleService;
import es.um.asio.service.service.article.impl.ArticleServiceImpl;
import es.um.asio.service.service.sparql.SparqlExecQuery;

@RunWith(SpringRunner.class)
public class ArticleProxyTest {

	/**
	 * Article proxy
	 */
	@Autowired
	private ArticleProxy proxy;
	
	@Autowired
	private ArticleMapper mapper;

	@Autowired
	private ArticleService service;

	@MockBean
	private SparqlExecQuery serviceSPARQL;

	ArticleFilter filter;

	Pageable pageable;

	@TestConfiguration
	static class ArticleProxyTestConfiguration {
		@Bean
		public ArticleProxy articleProxy() {
			return new ArticleProxyImpl();
		}
		
		@Bean
		public ArticleMapper articleMapper() {
			return new ArticleMapperDecorator();
		}

		@Bean
		@Primary
		public ArticleService articleService() {
			return new ArticleServiceImpl();
		}
	}

	@Before
	public void set_Up() {
		filter = new ArticleFilter();

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
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Article/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
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
			
			return this.mapper.convertPageFusekiResponseToDto(page);
		});
	}

	@Test
	public void proxyTest() {
		Page<ArticleDto> page = proxy.findPaginated(filter, pageable);

		// assertNotNull(page);
	}
}
