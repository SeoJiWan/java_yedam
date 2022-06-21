package control;

public class ForTest {
	
	public static void for1() {
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d x %d = %d\t", j, i, i * j);
			}
			System.out.println();
			
		}
		
	}
	
	public static void for2() {
		for (int i = 1; i < 10; i++) {
			for (int j = 10; j > 0; j--) {
				
				if (i < j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.println();
			
		}
		
	}
	
	
	public static void main(String[] args) {
		for1();
		for2();
	}

}
