package com.yedam.java.chap0902;

public class Product {
	
	//// 필드
	// 필드 - 익명 객체
	RemoteControl field = new RemoteControl() {
		
		// 필드
		String message = "스마트TV";
		
		// 메서드
		void print() {
			System.out.println("제품 종류 : " + message);
		}
		
		@Override
		public void turnOn() {
			print();
			System.out.println("전원을 켭니다.");
		}
		
		@Override
		public void turnOff() {
			print();
			System.out.println("전원을 끕니다.");
		}
	};
	
	
	//// 메서드
	// 로컬변수 - 익명 객체
	void method1() {
		
		int volume = 10;
		
		RemoteControl var = new RemoteControl() {

			// 필드
			String message = "Audio";
			
			// 메서드
			void print() {
				System.out.println("제품 종류 : " + message);
			}
			
			@Override
			public void turnOn() {
				print();
				System.out.println("전원을 켭니다.");
				System.out.println("현재볼륨 : " + volume);
			}
			
			@Override
			public void turnOff() {
				print();
				System.out.println("전원을 끕니다.");
			}
		};
		
		var.turnOn();
		var.turnOff();
	}
	
	// 매개변수 - 익명 객체
	void method2(RemoteControl rc) {
		rc.turnOn();
		rc.turnOff();
	}

}
