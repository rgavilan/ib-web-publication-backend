package es.um.asio.service.proxy.editorrole.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.EditorRoleDto;
import es.um.asio.service.filter.editorrole.EditorRoleFilter;
import es.um.asio.service.mapper.EditorRoleMapper;
import es.um.asio.service.proxy.editorrole.EditorRoleProxy;
import es.um.asio.service.service.editorrole.EditorRoleService;

/**
 * Implementación del Proxy para EditorRole
 *
 */
@Service
public class EditorRoleProxyImpl implements EditorRoleProxy {

	@Autowired
	private EditorRoleService service;
	
	@Autowired
	private EditorRoleMapper mapper;
	
	@Override
	public Page<EditorRoleDto> findPaginated(EditorRoleFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
