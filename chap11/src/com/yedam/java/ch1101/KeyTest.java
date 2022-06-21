package com.yedam.java.ch1101;

import java.util.HashMap;
import java.util.Map;

public class KeyTest {
	
	public static void main(String[] args) {
		
		Map<Key, String> map = new HashMap<Key, String>();
		
		map.put(new Key(1), "홍길도");
		
		String val = map.get(new Key(1)); 
		// 같으려면 hashCode 와 equals 메서드 다 오버라이딩 해야함
		System.out.println(val);
	}

}
