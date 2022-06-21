package array;

import java.util.Random;

public class Array2 {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		// 1차원 배열
		int[] intArr = new int[2];
		
		for (int i = 0; i < intArr.length; i++) {
			System.out.println("intArr[" + i + "] : " + intArr[i]);
		}
		
		System.out.println();	
		
		// 2차원 배열
		int[][] intArr2 = new int[3][2]; // int[2] 이 총 3개 존재하는 2차원배열  
		
		for (int i = 0; i < intArr2.length; i++) {
			for (int j = 0; j < intArr2[i].length; j++) {
				intArr2[i][j] = rd.nextInt(99);
			}
		}
		
		for (int i = 0; i < intArr2.length; i++) {
			for (int j = 0; j < intArr2[i].length; j++) {
				System.out.println("intArr2[" + i + "][" + j + "] : " + intArr2[i][j]);
			}
		}
		
		System.out.println();
		
		// 2차원 배열 - 1차원 배열의 크기가 다른 경우
		int[][]	intArr3 = new int[2][];
		intArr3[0] = new int[3];
		intArr3[1] = new int[5];
		
		for (int i = 0; i < intArr3.length; i++) {
			for (int j = 0; j < intArr3[i].length; j++) {
				intArr3[i][j] = rd.nextInt(99);
			}
		}
		
		for (int i = 0; i < intArr3.length; i++) {
			for (int j = 0; j < intArr3[i].length; j++) {
				System.out.println("intArr2[" + i + "][" + j + "] : " + intArr3[i][j]);
			}
		}
		
		System.out.println();
		
		int[][] javaScore = { {95, 82}, {92, 68, 54} };
		
		for (int i = 0; i < javaScore.length; i++) {
			for (int j = 0; j < javaScore[i].length; j++) {
				System.out.println("javaScore[" + i + "][" + j + "] : " + javaScore[i][j]);
			}
		}
		
		// 향상된 for문
		for (int[] is : javaScore) {
			for (int i : is) {
				System.out.println(i);
				
			}
			
		}
		
		
		
	}

}
