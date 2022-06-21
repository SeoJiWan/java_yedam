package com.yedam.java.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StringSet {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("jdbc");
		set.add("sevlet/jsp");
		set.add("java");
		set.add("ibatis");
		
		
		System.out.println(set.size());
		
		for (String string : set) {
			System.out.println(string);
		}
		System.out.println();
		
		String elem = "";
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			elem += iter.next() + " ";
		}
		System.out.println("elem : " + elem);
		
		set.remove("jdbc");
		set.remove("ibatis");
		
		System.out.println();
		
		for (String string : set) {
			System.out.println(string);
		}
		
		set.clear();
		
		System.out.println();
		
		if (set.isEmpty()) {
			System.out.println("set is empty");
		}
		
		
	}
}
