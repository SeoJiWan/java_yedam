package com.yedam.java.chap1501.useGeneric;

public class Util {
	
	// <T> Box<T>~ 제네릭 타입의 리턴, 
	public static <T, S> BoxA<T, S> boxing(T t, S s) {
		BoxA<T, S> box = new BoxA<>();
		box.setT(t);
		box.setS(s);
		return box;
	}

}
