package es.um.asio.service.mapper.decorator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;

import es.um.asio.service.mapper.BaseMapper;
import es.um.asio.service.model.FusekiResponse;
import es.um.asio.service.util.PageImplHelper;

public class BaseMapperDecorator<T> implements BaseMapper<T> {
	/**
	 * Logger
	 */
	private final Logger logger = LoggerFactory.getLogger(BaseMapperDecorator.class);
	
	protected Class<T> type;

	@Override
	public T convertFusekiObjectToDto(Object object) {
		Map<String, Map<String, String>> map = (Map<String, Map<String, String>>) object;
		
		try {			
			T instance = (T) this.type.getDeclaredConstructor().newInstance();
			
			for (Entry<String, Map<String, String>> entry : map.entrySet()) {
				this.set(instance, entry.getKey(), entry.getValue() != null ? entry.getValue().get("value") : null);
			}
			
			return instance;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<T> convertFusekiResponseToDto(List<Object> response) {
		final List<T> result = new ArrayList<>();
		
		for (Object element : response) {
			result.add(this.convertFusekiObjectToDto(element));
		}
		
		return result;
	}

	@Override
	public PageImplHelper<T> convertPageFusekiResponseToDto(Page<FusekiResponse> page) {
		List<Object> content = this.getFusekiResponseContent(page.getContent().get(0));
		
		return new PageImplHelper<>(this.convertFusekiResponseToDto(content), page.getPageable(), page.getTotalElements());
	}
	
	private List<Object> getFusekiResponseContent(FusekiResponse response) {
		Map<String, Object> mapResults = (Map<String, Object>) response.getResults();
		
		return (List<Object>) mapResults.get("bindings");
    }
	
	private void set(Object object, String fieldName, Object fieldValue) {
        try {
            Field field = this.type.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(object, fieldValue);
        } catch (NoSuchFieldException e) {
        	logger.error("Class {}: no field {}", this.type.getCanonicalName(), fieldName);
            return;
        } catch (IllegalArgumentException e) {
        	logger.error("Class {}: incorrect type for field {}", this.type.getCanonicalName(), fieldName);
			return;
		} catch (IllegalAccessException e) {
			logger.error("Class {}: field {} inaccessible", this.type.getCanonicalName(), fieldName);
			return;
		}
	}
}
