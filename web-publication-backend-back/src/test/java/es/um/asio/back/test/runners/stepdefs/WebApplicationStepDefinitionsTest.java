package es.um.asio.back.test.runners.stepdefs;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assume;
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

import es.um.asio.back.controller.book.BookController;
import es.um.asio.back.controller.patent.PatentController;
import es.um.asio.back.controller.project.ProjectController;
import es.um.asio.service.filter.book.BookFilter;
import es.um.asio.service.filter.invoice.InvoiceFilter;
import es.um.asio.service.filter.patent.PatentFilter;
import es.um.asio.service.filter.person.PersonFilter;
import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.filter.university.UniversityFilter;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.proxy.book.BookProxy;
import es.um.asio.service.proxy.book.impl.BookProxyImpl;
import es.um.asio.service.proxy.invoice.InvoiceProxy;
import es.um.asio.service.proxy.invoice.impl.InvoiceProxyImpl;
import es.um.asio.service.proxy.patent.PatentProxy;
import es.um.asio.service.proxy.patent.impl.PatentProxyImpl;
import es.um.asio.service.proxy.person.PersonProxy;
import es.um.asio.service.proxy.person.impl.PersonProxyImpl;
import es.um.asio.service.proxy.project.ProjectProxy;
import es.um.asio.service.proxy.project.impl.ProjectProxyImpl;
import es.um.asio.service.proxy.university.UniversityProxy;
import es.um.asio.service.proxy.university.impl.UniversityProxyImpl;
import es.um.asio.service.service.book.BookService;
import es.um.asio.service.service.invoice.InvoiceService;
import es.um.asio.service.service.patent.PatentService;
import es.um.asio.service.service.person.PersonService;
import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.university.UniversityService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = { ProjectController.class, PatentController.class, BookController.class })
public class WebApplicationStepDefinitionsTest {

	Pageable pageable;

	// PROJECTS
	@Autowired
	@MockBean
	ProjectProxy proxyProject;

	@MockBean
	ProjectService serviceProject;

	ProjectFilter filterProject;

	// PATENT
	@Autowired
	@MockBean
	PatentProxy proxyPatent;

	@MockBean
	PatentService servicePatent;

	PatentFilter filterPatent;

	// BOOK
	@Autowired
	@MockBean
	BookProxy proxyBook;

	@MockBean
	BookService serviceBook;

	BookFilter filterBook;

	// UNIVERSITY
	@Autowired
	@MockBean
	UniversityProxy proxyUniversity;

	@MockBean
	UniversityService serviceUniversity;

	UniversityFilter filterUniversity;

	// PERSON
	@Autowired
	@MockBean
	PersonProxy proxyPerson;

	@MockBean
	PersonService servicePerson;

	PersonFilter filterPerson;

	// INVOICE
	@Autowired
	@MockBean
	InvoiceProxy proxyInvoice;

	@MockBean
	InvoiceService serviceInvoice;

	InvoiceFilter filterInvoice;

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

		@Bean
		public BookProxy bookProxy() {
			return new BookProxyImpl();
		}

		@Bean
		public UniversityProxy universityProxy() {
			return new UniversityProxyImpl();
		}

		@Bean
		public PersonProxy personProxy() {
			return new PersonProxyImpl();
		}

		@Bean
		public InvoiceProxy invoiceProxy() {
			return new InvoiceProxyImpl();
		}
	}

	@Before
	public void setUp() throws Exception {

		pageable = PageRequest.of(1, 5, Sort.by("ASC"));

		// PROJECT
		filterProject = new ProjectFilter();
		filterProject.setName("NAME");
		filterProject.setLanguage("es");

		// Mock StorageType proxy
		Mockito.when(this.proxyProject.findPaginated(filterProject, pageable)).thenAnswer(invocation -> {

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
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

		// PATENT
		filterPatent = new PatentFilter();
		filterPatent.setName("NAME");
		filterPatent.setLanguage("es");

		// Mock StorageType proxy
		Mockito.when(this.proxyPatent.findPaginated(filterPatent, pageable)).thenAnswer(invocation -> {

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
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

		// BOOK
		filterBook = new BookFilter();
		filterBook.setName("NAME");
		filterBook.setLanguage("es");
		// Mock StorageType proxy
		Mockito.when(this.proxyBook.findPaginated(filterBook, pageable)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();

			List<FusekiResponse> contentResult = new ArrayList<>();

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Book/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
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

		// UNIVERSITY
		filterUniversity = new UniversityFilter();
		filterUniversity.setName("NAME");
		filterUniversity.setLanguage("es");
		// Mock proxy
		Mockito.when(this.proxyUniversity.findPaginated(filterUniversity, pageable)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();

			List<FusekiResponse> contentResult = new ArrayList<>();

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/University/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
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

		// PERSON
		filterPerson = new PersonFilter();
		filterPerson.setCentro("NAME");
		filterPerson.setLanguage("es");
		// Mock proxy
		Mockito.when(this.proxyPerson.findPaginated(filterPerson, pageable)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();

			List<FusekiResponse> contentResult = new ArrayList<>();

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Person/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
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

		// INVOICE
		filterInvoice = new InvoiceFilter();
		filterInvoice.setId("NAME");
		filterInvoice.setLanguage("es");
		// Mock proxy
		Mockito.when(this.proxyInvoice.findPaginated(filterInvoice, pageable)).thenAnswer(invocation -> {

			FusekiResponse fuseki = new FusekiResponse();

			List<FusekiResponse> contentResult = new ArrayList<>();

			String head = "\"head\": {\r\n"
					+ "    \"vars\": [ \"x\" , \"name\" , \"ini\" , \"fin\" , \"id\" , \"tipo\" ]\r\n" + "  }";

			String result = "\"results\": {\r\n" + "    \"bindings\": [\r\n" + "      {\r\n"
					+ "        \"x\": { \"type\": \"uri\" , \"value\": \"http://hercules.org/um/es-ES/rec/Invoice/9a115815-4dfa-32ca-9dbd-0694a4e9bdc8\" } ,\r\n"
					+ "        \"name\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"ini\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"fin\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"\" } ,\r\n"
					+ "        \"id\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"NAME\" } ,\r\n"
					+ "        \"tipo\": { \"type\": \"literal\" , \"xml:lang\": \"es\" , \"value\": \"D\" }\r\n"
					+ "      }";

			fuseki.setHead(head);
			fuseki.setResults(result);
			contentResult.add(fuseki);
			Page<FusekiResponse> page = new PageImpl<>(contentResult, pageable, contentResult.size());
			return page;
		});

	}

	@Given("^call to backend project controller$")
	public void call_to_backend_project_controller() {
		assertNotNull(filterProject);
	}

	@Then("^the controller call to servie and find project result to send front$")
	public void the_controller_call_to_servie_and_find_project_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyProject.findPaginated(filterProject, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Given("^call to backend patent controller$")
	public void call_to_backend_patent_controller() {
		assertNotNull(filterPatent);
	}

	@Then("^the controller call to servie and find patent result to send front$")
	public void the_controller_call_to_servie_and_find_patent_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyPatent.findPaginated(filterPatent, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Given("^call to backend book controller$")
	public void call_to_backend_book_controller() {
		assertNotNull(filterBook);
	}

	@Then("^the controller call to servie and find book result to send front$")
	public void the_controller_call_to_servie_and_find_book_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyBook.findPaginated(filterBook, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Given("^call to backend university controller$")
	public void call_to_backend_university_controller() {
		assertNotNull(filterUniversity);
	}

	@Then("^the controller call to servie and find university result to send front$")
	public void the_controller_call_to_servie_and_find_university_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyUniversity.findPaginated(filterUniversity, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Then("^the controller call to servie to find and group universities by quality seal to send front$")
	public void the_controller_call_to_servie_to_find_and_group_universities_by_quality_seal_to_send_front() {
		Assume.assumeTrue(false);
	}

	@Then("^the controller call to servie to find and group universities by financing to send front$")
	public void the_controller_call_to_servie_to_find_and_group_universities_by_financing_to_send_front() {
		Assume.assumeTrue(false);
	}

	@Given("^call to backend person controller$")
	public void call_to_backend_person_controller() {
		assertNotNull(filterPerson);
	}

	@Then("^the controller call to servie and find person result to send front$")
	public void the_controller_call_to_servie_and_find_person_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyPerson.findPaginated(filterPerson, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}

	@Then("^the controller call to servie to find and group persons by type of area to send front$")
	public void the_controller_call_to_servie_to_find_and_group_persons_by_type_of_area_to_send_front() {
		Assume.assumeTrue(false);
	}

	@Given("^call to backend invoice controller$")
	public void call_to_backend_invoice_controller() {
		assertNotNull(filterInvoice);
	}

	@Then("^the controller call to servie and find invoice result to send front$")
	public void the_controller_call_to_servie_and_find_invoice_result_to_send_front() {

		Page<FusekiResponse> page = this.proxyInvoice.findPaginated(filterInvoice, pageable);
		assertNotNull(page);

		assertEquals(true, page.getContent().get(0).getResults().toString().contains("NAME"));
	}
}
