package com.yedam.java.chap1501.useGeneric;

public class Container<T, S> {
	
	private T t;
	private S s;
	
	
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public S getS() {
		return s;
	}
	public void setS(S s) {
		this.s = s;
	}
	
	public String printInfo() {
		return getS() + String.valueOf(getT());
	}
	
	public static <K, V> void isEqual(Pair<K, V> p1, Pair<K, V> p2) {
		if (p1.getValue() == p2.getValue()) {
			System.out.println(p1.getValue() + ", " + p2.getValue() + " 는 같습니다.");
		}
		else {
			System.out.println(p1.getValue() + ", " + p2.getValue() + " 는 다릅니다.");
		}
	}
	
	
	
	

}
