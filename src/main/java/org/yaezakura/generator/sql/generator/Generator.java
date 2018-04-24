package org.yaezakura.generator.sql.generator;

import org.yaezakura.generator.sql.Sql;

public interface Generator {
	Sql next();
}