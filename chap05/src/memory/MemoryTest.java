package memory;

public class MemoryTest {
	
	public static void test1(int a, int b) {
		a = a + 10;
		b = b + 10;
		System.out.println(a + ":" + b);
		
	}
	
	
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		test1(a, b);
		
		System.out.println(a + ":" + b);
	}

}
