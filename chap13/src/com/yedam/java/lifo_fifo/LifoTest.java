package com.yedam.java.lifo_fifo;

import java.util.Stack;

public class LifoTest {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
//		stack.forEach(System.out::println);
		
		while (!stack.isEmpty()) {
			System.out.println("\t\tstack size : " + stack.size());
			int val = stack.pop();
			
			System.out.println("꺼내온 값 : " + val);
		}
	}
}
