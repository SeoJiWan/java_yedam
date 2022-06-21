package com.yedam.java.list;

import java.util.List;

public class ThreadA extends Thread {
	
	private List<Integer> list;

	
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		
		for (Integer integer : list) {
			System.out.println(Thread.currentThread().getName() + " : " + integer);
		}
	}
}
