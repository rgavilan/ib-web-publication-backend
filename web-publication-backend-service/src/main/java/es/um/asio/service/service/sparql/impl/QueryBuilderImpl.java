package es.um.asio.service.service.sparql.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import es.um.asio.service.model.Entity;
import es.um.asio.service.service.sparql.QueryBuilder;
import es.um.asio.service.util.FusekiConstants;

@Service
public class QueryBuilderImpl implements QueryBuilder {
	
	@Override
	public Map<String, String> queryChunks(Entity entity, Pageable pageable) {
		
		String selectChunk = this.selectChunk(entity.getFields());
		String typeChunk = this.typeChunk(entity.getEntity());
		String fieldsChunk = this.fieldsChunk(entity.getFields());		
		String limit = String.valueOf(pageable.getPageSize());
		String offset = String.valueOf(pageable.getOffset());
		
		StringBuilder order = new StringBuilder();
		
		for (Order o : pageable.getSort().toList()) {
			order.append(order.toString().length() > 0 ? " " : "");
			order.append(o.isAscending() ? FusekiConstants.ORDER_ASC : FusekiConstants.ORDER_DESC);
			order.append("(?");
			order.append(o.getProperty());
			order.append(")");
		}
		
		Map<String, String> map = new HashMap<>();
		map.put(FusekiConstants.SELECT_CHUNK, selectChunk);
		map.put(FusekiConstants.COUNT_CHUNK, FusekiConstants.COUNT_CHUNK_TEMPLATE);
		map.put(FusekiConstants.TYPE_CHUNK, typeChunk);
		map.put(FusekiConstants.FIELDS_CHUNK, fieldsChunk);
		if (order.toString().length() > 0) {
			map.put(FusekiConstants.ORDER, order.toString());
		}
		map.put(FusekiConstants.LIMIT, limit);
		map.put(FusekiConstants.OFFSET, offset);
				
		return map;
	}

	
	private String selectChunk(List<String> fields) {
		StringBuilder strBuilder = new StringBuilder();
		for(String field: fields) {
			strBuilder.append("?");
			strBuilder.append(field);
			strBuilder.append(" ");
		}
		return strBuilder.toString();
	}
	
	
	private String typeChunk(String entity) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("?x");
		strBuilder.append(" <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ");
		strBuilder.append(" <http://hercules.org/um/es-ES/rec/");
		strBuilder.append(entity);
		strBuilder.append("> . ");
		
		return strBuilder.toString();
	}
	
	private String fieldsChunk(List<String> fields) {
		StringBuilder strBuilder = new StringBuilder();
		for(String field: fields) {
			strBuilder.append("?x ");
			strBuilder.append("<http://hercules.org/um/es-ES/rec/");
			strBuilder.append(field);
			strBuilder.append("> ");
			strBuilder.append("?");
			strBuilder.append(field);
			strBuilder.append(" . ");
		}
		return strBuilder.toString();
	}

}
