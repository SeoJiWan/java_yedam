package chap01;

public class Work01 {
	
	public static void decVar() {
		char grade = '상';
		String schoolNam = "예담";
		int score = 85;
		double avg = 4.235;
		int flag = 0b10_000_000;
		char firstChar = '\uAC00';
		char secondChar = 0xAC01;
		int salary = 1_000_000;
		boolean useYn = true;
		
		System.out.println(grade);
		System.out.println(score);
		System.out.println(avg);
		System.out.println(flag);
		System.out.println(firstChar);
		System.out.println(secondChar);
		System.out.println(salary);
		System.out.println(useYn);
		
	}
	
	
	public static void main(String[] args) {
		decVar();
	}

}
