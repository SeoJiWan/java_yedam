package chap07.com.yedam.java.ch0702.family;

public class ChildTest2 {
	
	public static void main(String[] args) {
		GrandFather pa = new Father();
		pa.method();
//		pa = new Uncle();
		
		System.out.println();
		
		if (pa instanceof Father) {
			Father fa = (Father) pa;
			fa.method();
			fa.method2();
		}
		else {
			System.out.println();
		}
	}

}
