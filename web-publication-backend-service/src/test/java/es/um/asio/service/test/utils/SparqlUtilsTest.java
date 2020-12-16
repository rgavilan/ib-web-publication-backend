package es.um.asio.service.test.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.util.SparqlUtils;

@RunWith(SpringRunner.class)
public class SparqlUtilsTest {

	SparqlUtils utils;

	@Test
	public void dateGETest() {
		utils = new SparqlUtils();
		String result = utils.dateGE("fin", "10/10/2020", "mm/dd/yyyy");
		assertNotNull(result);
	}

	@Test
	public void dateLETest() {
		utils = new SparqlUtils();
		String result = utils.dateLE("fin", "10/10/2020", "mm/dd/yyyy");
		assertNotNull(result);
	}

}
