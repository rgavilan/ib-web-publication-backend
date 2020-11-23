package es.um.asio.service.service.project.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import es.um.asio.service.filter.project.ProjectFilter;

public class Test {

	public static void main(final String[] args) {
		ProjectServiceImpl service = new ProjectServiceImpl();
		ProjectFilter filter = new ProjectFilter();
		Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.asc("name")));

		Page<String> page = service.findPaginated(filter, pageable);

		System.out.print(page);
	}
}
