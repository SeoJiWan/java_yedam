package memory;

public class MainTest {
	
	public static void main(String[] args) {
		
		int sum = 0;
		
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				String string = args[i];
				sum += Integer.parseInt(string);
				System.out.println(string);
			}
		}
		System.out.println("합계 = " + sum);
	}
}
