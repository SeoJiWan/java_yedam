package chap07.com.yedam.java.ch0702.family;

public class FamilyTest {

	public static void main(String[] args) {

		Father father = new Father();
		Uncle uncle = new Uncle();
		Child child = new Child();
		Cousin cousin = new Cousin();

		GrandFather pa = father;
		pa.method(); // father

		pa = uncle;
		pa.method(); // uncle

		pa = child;
		pa.method(); // child

		pa = cousin;
		pa.method(); // cousin
		
		System.out.println();
		
//		Father fa = uncle; // 타입변환 안됨.
		Father fa = child;
		fa.method(); // child
//		fa = cousin; // 타입변환 안됨.
		
		System.out.println();
		Uncle un = cousin;
//		un = fater; // 타입변환 안됨. 
//		un = child; // 타입변환 안됨.
		un.method(); // cousin

	}

}
