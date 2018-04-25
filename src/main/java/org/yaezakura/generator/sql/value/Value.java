package org.yaezakura.generator.sql.value;

import org.yaezakura.generator.sql.rule.Rule;

public abstract class Value {
	public abstract String get(Rule[] rules);
}
