package es.um.asio.service.util;

import java.text.MessageFormat;

public final class SparqlUtils {

	private static final String dateTemplate = "FILTER (strdt(concat(substr(?{0}, 0, 5), \"-\", substr(?{0}, 6, 2), \"-\", substr(?{0}, 9, 2)), xsd:date) {2} \"{1}\"^^xsd:date) . ";
	
	/**
	 * Date Greater or Equal.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @return the string
	 */
	public static String dateGE(String propertyName, String dateFilter) {
		return filter(propertyName, dateFilter, ">=");
	}
	
	/**
	 * Date Less or Equal.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @return the string
	 */
	public static String dateLE(String propertyName, String dateFilter) {
		return filter(propertyName, dateFilter, "<=");
	}
	
	/**
	 * Filter.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @param operator the operator
	 * @return the string
	 */
	private static String filter(String propertyName, String dateFilter, String operator) {
		String result = MessageFormat.format(dateTemplate, propertyName, dateFilter, operator);
		return result;
	}
}
