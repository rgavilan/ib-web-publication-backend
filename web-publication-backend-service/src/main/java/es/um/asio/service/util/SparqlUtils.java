package es.um.asio.service.util;

import java.text.MessageFormat;

public final class SparqlUtils {
	
	/**
	 * Date Greater or Equal.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @param format the date format
	 * @return the string
	 */
	public static String dateGE(String propertyName, String dateFilter, String format) {
		return filter(propertyName, dateFilter, ">=", format);
	}
	
	/**
	 * Date Less or Equal.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @param format the date format
	 * @return the string
	 */
	public static String dateLE(String propertyName, String dateFilter, String format) {
		return filter(propertyName, dateFilter, "<=", format);
	}
	
	/**
	 * Filter.
	 *
	 * @param propertyName the property name
	 * @param dateFilter the date filter
	 * @param operator the operator
	 * @param format the date format
	 * @return the string
	 */
	private static String filter(String propertyName, String dateFilter, String operator, String format) {
		String result = MessageFormat.format(format, propertyName, dateFilter, operator);
		return result;
	}
}
