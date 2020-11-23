package es.um.asio.service.test.service.project;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import es.um.asio.service.service.project.ProjectService;
import es.um.asio.service.service.project.impl.ProjectServiceImpl;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {

	@Autowired
	private ProjectService projectService;

	@TestConfiguration
	static class ProjectServiceTestConfiguration {
		@Bean
		public ProjectService projectService() {
			return new ProjectServiceImpl();
		}
	}

	@Test
	public void testfindPaginatedProject() {

//		ProjectFilter filter = new ProjectFilter();
//		Pageable pageable = Pageable.unpaged();
//		Page<String> page = this.projectService.findPaginated(filter, pageable);
//
//		assertThat(page.getNumberOfElements()).isEqualTo(5);

	}
}
