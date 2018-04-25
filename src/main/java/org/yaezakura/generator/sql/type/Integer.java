package org.yaezakura.generator.sql.type;

import org.yaezakura.generator.sql.value.IntegerValue;
import org.yaezakura.generator.sql.value.Value;

public class Integer extends Type{

	@Override
	public Value value() {
		// TODO Auto-generated method stub
		return new IntegerValue();
	}

}
