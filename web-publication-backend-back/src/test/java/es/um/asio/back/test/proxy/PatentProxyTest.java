package es.um.asio.back.test.proxy;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.proxy.patent.PatentProxy;
import es.um.asio.service.service.patent.PatentService;

@RunWith(SpringRunner.class)
@WebMvcTest(PatentProxy.class)
@ActiveProfiles("unit-test")
public class PatentProxyTest {

	/**
	 * Proxy Project
	 */
	@Autowired
	private PatentProxy proxy;

	@MockBean
	private PatentService service;

	@Test
	public void test_Infraestructure() {
		assertNotNull(proxy);
	}
}
