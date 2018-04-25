package org.yaezakura.generator.sql.value;

import org.yaezakura.generator.sql.rule.Rule;

public class DateValue extends Value {

	@Override
	public String get(Rule[] rules) {
		return "\"";
	}

}
