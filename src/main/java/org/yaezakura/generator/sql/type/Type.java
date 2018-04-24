package org.yaezakura.generator.sql.type;

public abstract class Type {
	public static final Type INTEGER = new Integer();
	public static final Type DOUBLE = new Double();
	public static final Type VARCHAR = new Varchar();
	public static final Type DATE = new Date();
}
