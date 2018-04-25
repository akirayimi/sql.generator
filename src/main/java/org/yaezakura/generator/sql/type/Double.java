package org.yaezakura.generator.sql.type;

import org.yaezakura.generator.sql.value.DoubleVaule;
import org.yaezakura.generator.sql.value.Value;

public class Double extends Type{

	@Override
	public Value value() {
		// TODO Auto-generated method stub
		return new DoubleVaule();
	}

}
