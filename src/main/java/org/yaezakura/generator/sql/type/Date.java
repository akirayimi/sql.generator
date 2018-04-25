package org.yaezakura.generator.sql.type;

import org.yaezakura.generator.sql.value.DateValue;
import org.yaezakura.generator.sql.value.Value;

public class Date extends Type{

	@Override
	public Value value() {
		return new DateValue();
	}
}
