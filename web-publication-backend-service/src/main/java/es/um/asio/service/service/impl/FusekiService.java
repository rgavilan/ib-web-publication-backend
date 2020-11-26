package es.um.asio.service.service.impl;

import es.um.asio.service.filter.Filter;
import es.um.asio.service.model.Entity;

public abstract class FusekiService<T extends Filter> {
	public abstract String filtersChunk(T filter);
	public abstract Entity retrieveEntity();
}
