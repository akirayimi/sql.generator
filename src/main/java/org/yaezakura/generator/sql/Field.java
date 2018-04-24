package org.yaezakura.generator.sql;

import java.util.ArrayList;
import java.util.List;

import org.yaezakura.generator.sql.rule.Rule;
import org.yaezakura.generator.sql.type.Type;

public class Field {
	String fieldName;
	Type type;
	List<Rule> rules = new ArrayList<Rule>();
	void rule(Rule rule){
		rules.add(rule);
	}
}
