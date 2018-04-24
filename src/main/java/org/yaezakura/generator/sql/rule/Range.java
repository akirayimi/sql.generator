package org.yaezakura.generator.sql.rule;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Range<T> {
	private T[] range;
	public Range(T[] range){
		this.range = range;
	}
	
	public T next(){
		return range[new Random().nextInt(range.length)];
	}
	
	
	public static void main(String[] args) {
		Integer[] arr = {0,1,2,3,4,5,6,7,8,9};
		Range<Integer> r = new Range<Integer>(arr);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 1; i < 100000 ; i++){
			Integer val = r.next();
			Integer count = map.get(val);
			map.put(val, count == null ? 1 : count + 1);
		}
		System.out.println(map);
	}
}
