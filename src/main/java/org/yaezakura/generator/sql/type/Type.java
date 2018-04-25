package org.yaezakura.generator.sql.type;

import java.util.HashMap;
import java.util.Map;

import org.yaezakura.generator.sql.value.Value;

public abstract class Type {
	public static final Type INTEGER = new Integer();
	public static final Type DOUBLE = new Double();
	public static final Type VARCHAR = new Varchar();
	public static final Type DATE = new Date();
	
	private final static String[] INT_TYPE_INGORECASE = {"bigint", "int"};
	private final static String[] DOUBLE_TYPE_INGORECASE = {"float", "double"};
	private final static String[] VARCHAR_TYPE_INGORECASE = {"varchar", "char", "text"};
	private final static String[] DATE_TYPE_INGORECASE = {"date", "datetime", "timestamp", "time"};
	
	private final static Map<String, Type> MAP = new HashMap<String, Type>();
	static {
		for (String intType : INT_TYPE_INGORECASE)
			MAP.put(intType, INTEGER);
		for (String doubleType : DOUBLE_TYPE_INGORECASE)
			MAP.put(doubleType, DOUBLE);
		for (String varcharType : VARCHAR_TYPE_INGORECASE)
			MAP.put(varcharType, VARCHAR);
		for (String dateType : DATE_TYPE_INGORECASE)
			MAP.put(dateType, DATE);
	}
	
	public abstract Value value();
	
	/**
	 * 根据typeName(int, varchar)等字符串信息返回类型.
	 * @return
	 */
	public static Type getType(String typeName){
		typeName = typeName.replaceAll("\\(.+\\)", "");
		return MAP.get(typeName.toLowerCase());
	}
}
