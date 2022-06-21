package backjun.p1065;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	static boolean hansoo(int num) {
		// 숫자 입력
		String strNum = Integer.toString(num);
				
		// split 하여 int 형변환을 통해 배열에 삽입
		String[] strNumList = strNum.split("");
		
		// 각 숫자의 자리를 담을 int 배열
		int[] numList = new int[strNum.length()];
		for (int i = 0; i < numList.length; i++) {
			numList[i] = Integer.parseInt(strNumList[i]);
		}
		
		// hansoo 판별
		// 등차 수열인지 확인 --> 각 수의 차이를 arraylist 에 추가
		ArrayList<Integer> diffList = new ArrayList<Integer>();
		for (int i = 0; i < numList.length - 1; i++) {
			int diff = numList[i] - numList[i + 1];
			diffList.add(diff);
		}
		
		// 중복 제거 --> diffSet 길이가 1이면 한수
		Set<Integer> diffSet = new HashSet<Integer>(diffList);
		if (diffSet.size() == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static int run() {
		// 1~9 까지는 숫자의 차를 구할 수 없으므로 위 로직 사용 x 
		int ans = 9;
		// 숫자 입력
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		// 한수 count
		for (int i = 10; i <= num; i++) {
			boolean isCorrect = hansoo(i);
			if (isCorrect == true) {
				ans++;
			}
		}
		
		// 예외처리 --> 주어진 숫자의 자릿수가 한 자리 또는 두 자리면 주어진 숫자가 정답
		String strNum = Integer.toString(num);
		if (strNum.length() == 1 || strNum.length() == 2) {
			ans = num;
		}
		
		return ans;
	}
	
	
	public static void main(String[] args) {
		int answer = run();
		System.out.println(answer);
		
	}

}
