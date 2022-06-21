package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("java");
		list.add("jdbc");
		list.add("servlet/jsp");
		list.add(2, "database");
		list.add("ibatis");
		
		System.out.println(list.size());
		System.out.println();
		
		System.out.println(list.get(2));
		System.out.println();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("ibatis");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " : " + list.get(i));
		}
		
	}

}
