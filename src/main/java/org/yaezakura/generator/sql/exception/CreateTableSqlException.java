package org.yaezakura.generator.sql.exception;

public class CreateTableSqlException extends RuntimeException{
	public CreateTableSqlException(){
		super();
	}
	
	public CreateTableSqlException(String msg){
		super(msg);
	}
}
