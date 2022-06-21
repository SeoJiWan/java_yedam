package com.yedam.java.set;

import java.util.HashSet;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		
		String data1 = "java";
		String data2 = new String("java");
		
		System.out.println("= -> " + (data1 == data2));
		
		Set<String> set = new HashSet<String>();
		set.add(data1);
		set.add(data2);
		
		System.out.println("set.size -> " + set.size());
		
		
	}

}
