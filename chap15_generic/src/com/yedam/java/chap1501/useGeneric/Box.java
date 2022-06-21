package com.yedam.java.chap1501.useGeneric;

// 타입을 제네릭으로 선언 -> 타입을 무엇을 쓸지 모를때 제네릭 사용
public class Box<T, S, K> {
	
	T t;
	S s;
	K k;
	int num;
	
	
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
	public K getK() {
		return k;
	}
	public void setK(K k) {
		this.k = k;
	}
	
	
	
}
