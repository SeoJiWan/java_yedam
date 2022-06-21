package com.yedam.java.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringTest {
	
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hello", 1);
		map.put("hi", 2);
		map.put("bye", 3);
		
		System.out.println("총 entry 수 : " + map.size());
		
		
		
		Integer integer = map.get("hello");
		System.out.println(integer);
		
		if (map.containsKey("hi")) {
			System.out.println("hi 는 있네");
		}
		
		// key 값이 있으면 value 값 반환, key 값이 없으면 0 반환
		Integer orDefault = map.getOrDefault("bye", 0);
		System.out.println(orDefault);
		
		Set <Map.Entry<String, Integer>> set = map.entrySet();
//		set.forEach(x -> System.out.println(x)); // 람다식 이용 - x를 두번 적음 --> 아래와 같이 더블 콜론 (::) 이용하여 파라미터 안 적을수 있음
		set.forEach(System.out::println); // [인스턴스]::[메서드] --> System.out 이 인스턴스, println 이 메서드 
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = iter.next();
			
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
		
		System.out.println();
		
		for (Map.Entry<String, Integer>entry : map.entrySet()) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " : " + val);
		}
		
	}

}
