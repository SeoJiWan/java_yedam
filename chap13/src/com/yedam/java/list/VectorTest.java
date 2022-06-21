package com.yedam.java.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		
//		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list = new Vector<Integer>();
		
		ThreadA thA = new ThreadA();
		thA.setList(list);
		thA.start();
		
		ThreadB thB = new ThreadB();
		thB.setList(list);
		thB.start();
	}
}
