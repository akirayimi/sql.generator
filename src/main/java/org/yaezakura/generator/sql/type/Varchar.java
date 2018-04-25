package org.yaezakura.generator.sql.type;

import org.yaezakura.generator.sql.value.Value;
import org.yaezakura.generator.sql.value.VarcharValue;

public class Varchar extends Type{

	@Override
	public Value value() {
		// TODO Auto-generated method stub
		return new VarcharValue();
	}

}
