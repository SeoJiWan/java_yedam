package com.yedam.java.chap0902;

public class Anonymous {

	// 필드
	Person field = new Person() { // 익명자식객체

		// 필드
		String job = "돈 많은 백수";

		// 메서드
		void work() {
			System.out.println("놀고 먹으면서 돈을 법니다.");
		}

		@Override // 실제적으로 사용되는것은 오버라이딩 된 메서드만 실행된다.
		void wake() {
			System.out.println("일어나고 싶을 때 일어납니다.");
			work();
		}

	};

	// 생성자

	// 메서드
	void method1() {
		
		// 로컬변수
		Person var = new Person() {
			
			// 필드
			String job = "취준생";
			
			// 메서드
			void work() {
				System.out.println("취직합니다.");
			}

			@Override
			void wake() {
				System.out.println("일어나기 싫습니다.");
				work();
			}
		};
		
		var.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
}
