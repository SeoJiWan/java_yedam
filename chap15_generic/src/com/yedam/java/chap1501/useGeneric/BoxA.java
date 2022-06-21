package com.yedam.java.chap1501.useGeneric;

public class BoxA<T, S> {
	
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
	
	
	public static <K, V> boolean compare(Pair<K,V> p1, 
										 Pair<K,V> p2) {
		
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompre = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompre;
	}
	
	
	public static <K, V> V printInfo(K key) {
		V v = null;
		return v;
	}
	
	
	
	

}
