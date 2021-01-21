package es.um.asio.service.proxy.expo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.dto.ExpoDto;
import es.um.asio.service.filter.expo.ExpoFilter;
import es.um.asio.service.mapper.ExpoMapper;
import es.um.asio.service.proxy.expo.ExpoProxy;
import es.um.asio.service.service.expo.ExpoService;

/**
 * Implementación del Proxy para Expo
 *
 */
@Service
public class ExproProxyImpl implements ExpoProxy {

	@Autowired
	private ExpoService service;
	
	@Autowired
	private ExpoMapper mapper;
	
	@Override
	public Page<ExpoDto> findPaginated(ExpoFilter filter, Pageable pageable) {
		return this.mapper.convertPageFusekiResponseToDto(this.service.findPaginated(filter, pageable));
	}
}
