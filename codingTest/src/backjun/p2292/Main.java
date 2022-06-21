package backjun.p2292;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] numList = new int[2];
		int d = 6;
		int cnt = 1;
		numList[1] = 1;
		
		if (num == 1) {
			System.out.println(1);
		}
		
		else {
			while(true) {
				numList[0] = numList[1];
				System.out.println("numList[0] : " + numList[0]);
				numList[1] = numList[0] + d * cnt;
				System.out.println("numList[1] : " + numList[1]);
//				for (int i = 0; i < numList.length; i++) {
//					System.out.println(numList[i]);
//				}

				cnt++;

				if (num >= numList[0] && num <= numList[1]) {
					System.out.println(cnt);
					break;
				}
			} 
		}
		
	}
}
