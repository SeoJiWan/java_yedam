package com.yedam.java.ch1601;

public class MainPractice {
	
	public static void main(String[] args) {
		
		MyFunInterfaceA mfiA = () -> {
			System.out.println("mfi test");
		};
		mfiA.methodA();
		
		MyFunInterfaceA mfiA2;
		mfiA2 = () -> { int a = 4; int b = 2; System.out.println(a + b); };
		mfiA2.methodA();
		
		mfiA2 = () -> System.out.println("mfi test3");
		mfiA2.methodA();
		
		
		MyFunInterfaceB mfiB = (a) -> {
			for (int i = 0; i < 6; i++) {
				System.out.print(a + i + " ");
			}
		};
		mfiB.methodB(4);
		
		System.out.println();
		
		MyFunInterfaceB mfiB2;
		mfiB2 = (a) -> { int b = 4; System.out.println(a + b); };
		mfiB2.methodB(9);
		
		
		MyFunInterfaceC mfiC = (a, b) -> {
			int max = 0;
			if (a > b) {
				max = a;
			}
			else if (a < b){
				max = b;
			}
			else {
				max = a;
			}
			return max;
		};
		int ans = mfiC.methodC(1, 3);
		System.out.println(ans);
		
		mfiC = (a, b) -> { return a + b; };
		System.out.println(mfiC.methodC(1, 4));
		
		
		
		
	}

}
