package memory;

public class EqualTest {
	
	public static void main(String[] args) {
		
		// 배열
		int[] a = new int[5];
		int[] b = a; // 얕은 복사
		int[] c = new int[a.length];
		System.arraycopy(a, 0, c, 0, a.length); // deep copy
		
		b[0] = 100;
		
		System.out.println(a[0]);
		System.out.println(a == b);
		
		
		// 스트링
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}

}
