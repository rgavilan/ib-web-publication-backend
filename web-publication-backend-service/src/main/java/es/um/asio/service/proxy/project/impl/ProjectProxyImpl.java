package es.um.asio.service.proxy.project.impl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.project.ProjectFilter;
import es.um.asio.service.proxy.project.ProjectProxy;
import es.um.asio.service.service.project.ProjectService;

/**
 * Implementación del Proxy para Proyectos
 *
 */
@Service
public class ProjectProxyImpl implements ProjectProxy {

	@Autowired
	private ProjectService service;

	@Override
	public Page<LinkedHashMap> findPaginated(ProjectFilter filter, Pageable pageable) {
		return this.service.findPaginated(filter, pageable);

	}

}
