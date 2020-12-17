package es.um.asio.service.service.sparql.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		String typeChunk = this.typeChunk(entity.getEntity(), entity.getTypes());
		String fieldsChunk = this.fieldsChunk(entity.getFields());		
		String limit = String.valueOf(pageable.getPageSize());
		String offset = String.valueOf(pageable.getOffset());
		String order = this.orderChunk(pageable.getSort());
		String group = this.groupChunk(entity.getGroup());
		
		Map<String, String> map = new HashMap<>();
		map.put(FusekiConstants.SELECT_CHUNK, selectChunk);
		map.put(FusekiConstants.COUNT_CHUNK, FusekiConstants.COUNT_CHUNK_TEMPLATE);
		map.put(FusekiConstants.TYPE_CHUNK, typeChunk);
		map.put(FusekiConstants.FIELDS_CHUNK, fieldsChunk);
		map.put(FusekiConstants.GROUP, group);
		map.put(FusekiConstants.ORDER, order);
		map.put(FusekiConstants.LIMIT, limit);
		map.put(FusekiConstants.OFFSET, offset);
				
		return map;
	}

	
	private String selectChunk(List<String> fields) {
		StringBuilder strBuilder = new StringBuilder();
		
		for (String field: fields) {
			String fieldFinal = field.contains(":") ? field.split(":")[field.split(":").length - 1] : field;
			
			strBuilder.append("?");
			strBuilder.append(fieldFinal);
			strBuilder.append(" ");
		}
		
		return strBuilder.toString();
	}
	
	
	private String typeChunk(String entity, List<String> types) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (types != null && types.size() > 0) {
			strBuilder.append("VALUES ?type {");
			
			for (String type : types) {
				strBuilder.append(" <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ");
				strBuilder.append(" <http://hercules.org/um/es-ES/rec/");
				strBuilder.append(type);
				strBuilder.append("> ");
			}
			
			strBuilder.append("} ");
			strBuilder.append("?x <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ?type.");
		} else {
			strBuilder.append("?x");
			strBuilder.append(" <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> ");
			strBuilder.append(" <http://hercules.org/um/es-ES/rec/");
			strBuilder.append(entity);
			strBuilder.append("> . ");
		}
		
		return strBuilder.toString();
	}
	
	private String fieldsChunk(List<String> fields) {
		StringBuilder strBuilder = new StringBuilder();
		
		for (String field: fields) {
			if (field.contains("nowhere:")) {
				continue;
			}
			
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

	private String orderChunk(Sort sort) {
		StringBuilder strBuilder = new StringBuilder();
		
		List<Order> list = sort.toList();
		
		if (list != null && list.size() > 0) {
			strBuilder.append(FusekiConstants.ORDER );
			strBuilder.append(" ");
			
			for (Order o : list) {
				strBuilder.append(strBuilder.toString().length() > 0 ? " " : "");
				strBuilder.append(o.isAscending() ? FusekiConstants.ORDER_ASC : FusekiConstants.ORDER_DESC);
				strBuilder.append("(?");
				strBuilder.append(o.getProperty());
				strBuilder.append(")");
			}
		}
		
		return strBuilder.toString();
	}
	
	private String groupChunk(List<String> fields) {
		StringBuilder strBuilder = new StringBuilder();
		
		if (fields != null && fields.size() > 0) {
			strBuilder.append(FusekiConstants.GROUP);
			strBuilder.append(" ");
			
			for (String field: fields) {
				strBuilder.append("?");
				strBuilder.append(field);
				strBuilder.append(" ");
			}
		}
		
		return strBuilder.toString();
	}
}
