package org.yaezakura.generator.sql;

import org.yaezakura.generator.sql.rule.Rule;
import org.yaezakura.generator.sql.type.Type;

public class Field {
	String fieldName;
	Type type;
	
	Rule[] rules;
	
	public Field(String filedName, Type type) {
		this.fieldName = filedName;
		this.type = type;
	}


	void setRules(Rule[] rules){
		this.rules = rules;
	}
	
	
	String getValue(){
		return type.value().get(rules);
	}


	@Override
	public String toString() {
		return "{\"fieldName\":\"" + fieldName + "\",\"type\":\"" + type.getClass().getSimpleName()+ "\"} ";
	}

}
