package chap07.com.yedam.java.chap0701;

public class CalTest {
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println("원 면적 : " + calculator.areaCircle(9.8));
		
		Computor computor = new Computor();
		System.out.println("원 면적 : " + computor.areaCircle(9.8));
		
		System.out.println();
		computor.print();
	}

}
