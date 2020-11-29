package es.um.asio.service.test.service.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.ServiceConfig;
import es.um.asio.service.model.Entity;
import es.um.asio.service.service.project.ProjectService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ServiceConfig.class })
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;
	
	@Test
	public void testEntity() {

		Entity entity = new Entity("Proyecto", "description", "fin", "id", "ini", "name", "tipo");
		Entity entityFromService = projectService.retrieveEntity();
		assertThat(entityFromService).isEqualTo(entity);
	}
}
