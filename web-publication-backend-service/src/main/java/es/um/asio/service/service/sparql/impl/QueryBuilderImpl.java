package es.um.asio.service.service.sparql.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.um.asio.service.filter.Filter;
import es.um.asio.service.model.Entity;
import es.um.asio.service.service.sparql.QueryBuilder;

@Service
public class QueryBuilderImpl implements QueryBuilder {

	
	private String queryTemplate = "SELECT %s WHERE { %s %s %s } LIMIT %s offset %s";
	private String countStatement = "(COUNT(*) AS ?count)";
	
	@Override
	public String createSelectQuery(Entity entity, Filter filter, Pageable pageable) {
		
		String selectChunk = this.selectChunk(entity.getFields());
		String typeChunk = this.typeChunk(entity.getEntity());
		String fieldsChunk = this.fieldsChunk(entity.getFields());
		String filtersChunk = this.filtersChunk(filter);
		String limit = String.valueOf(pageable.getPageSize());
		String offset = String.valueOf(pageable.getOffset());
		
		String result = String.format(queryTemplate, selectChunk, typeChunk, fieldsChunk, filtersChunk, limit, offset);
		
		return result;
	}

	@Override
	public String createCountQuery(Entity entity, Filter filter, Pageable pageable) {
		String countChunk = this.countChunk();
		String typeChunk = this.typeChunk(entity.getEntity());
		String fieldsChunk = this.fieldsChunk(entity.getFields());
		String filtersChunk = this.filtersChunk(filter);
		String limit = String.valueOf(pageable.getPageSize());
		String offset = String.valueOf(pageable.getOffset());
		
		String result = String.format(queryTemplate, countChunk, typeChunk, fieldsChunk, filtersChunk, limit, offset);
		
		return result;
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
	
		
	private String countChunk() {
		return countStatement;
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
	
	private String filtersChunk(Filter filter) {
		
		return " FILTER (?id = \"15083\"@es) .\r\n" + 
				"  FILTER (?name = \"FP00-366\"@es) .";
	}
	
	
	
	

}
