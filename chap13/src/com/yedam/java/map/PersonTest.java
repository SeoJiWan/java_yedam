package com.yedam.java.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Map<Person, Integer> map = new HashMap<Person, Integer>();
		
		map.put(new Person(18, "wana"), 1);
		map.put(new Person(18, "ggg"), 2);
		map.put(new Person(20, "woo"), 3);
		map.put(new Person(2, "ddd"), 3);
		map.put(new Person(220, "ff"), 3);
		
		System.out.println(map.size());
		
		Set<Entry<Person, Integer>> entrySet1 = map.entrySet();
		entrySet1.forEach(System.out::println);
		
//		for (Map.Entry<Person, Integer> entry : map.entrySet()) {
//			Person key = entry.getKey();
//			Integer val = entry.getValue();
//			
//			System.out.println(key.age + "살, " + key.name);
//		}
		
		Map<Integer, String> map2 = new HashMap<Integer, String>();
		map2.put(1, "asdf");
		map2.put(2, "sdf");
		map2.put(3, "df");
		map2.put(4, "f");
		
		Set<Entry<Integer, String>> entrySet2 = map2.entrySet();
		entrySet2.forEach(System.out::println);
		
		
		
		
		
		
		
	}
	
	

}
