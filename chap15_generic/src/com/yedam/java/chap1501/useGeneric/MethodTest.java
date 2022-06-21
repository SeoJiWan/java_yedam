package com.yedam.java.chap1501.useGeneric;

public class MethodTest {
	
	public static void main(String[] args) {
		
		BoxA<Integer, String> intValue = Util.boxing(100, "aaa");
		
		Integer t = intValue.getT();
		System.out.println(t);
		
		String s = intValue.getS();
		System.out.println(s);
		
		
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "apple");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "banana");
		
		boolean compare = BoxA.compare(p1, p2);
		System.out.println(compare);
		
		
		String printInfo = (String) BoxA.printInfo("홍길동");
		System.out.println(printInfo);
		
		Pair<Integer, Integer> p3 = new Pair<Integer, Integer>(1, 1);
		Pair<Integer, Integer> p4 = new Pair<Integer, Integer>(1, 1);
		
		Container.isEqual(p3, p4);
		
		Container<Integer, String> container = new Container<Integer, String>();
		container.setS("piano");
		container.setT(2);
		
		String str = container.printInfo();
		System.out.println(str);
		
		
		
		
	}
}
