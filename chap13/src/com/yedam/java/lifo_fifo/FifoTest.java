package com.yedam.java.lifo_fifo;

import java.util.LinkedList;
import java.util.Queue;

public class FifoTest {
	
	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		
		while (!q.isEmpty()) {
			System.out.println("\t\tq size : " + q.size());
			int val = q.poll();
			
			System.out.println("꺼낸 값 : " + val);
		}

	}
}
