package org.yaezakura.generator.sql.rule;

import java.util.Random;

import org.yaezakura.generator.sql.type.Type;

public class Range<T extends Type> {
	private T[] range;
	public Range(T[] range){
		this.range = range;
	}
	
	public T next(){
		return range[new Random().nextInt(range.length)];
	}
}
