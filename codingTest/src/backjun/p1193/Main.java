package backjun.p1193;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String a = "1/1";
//		String b = "1/2";
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(a);
//		arr.add(b);

		int num = Integer.parseInt(sc.nextLine());

		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < i; j++) {
					int c = Integer.parseInt(arr.get(arr.size() - 1).substring(0, 1));
					int d = Integer.parseInt(arr.get(arr.size() - 1).substring(2));

					String s = Integer.toString(++c) + "/" + Integer.toString(--d);
					arr.add(s);
					System.out.println(s);
				}
				String e = arr.get(arr.size() - 1).substring(0, 1);
				String f = arr.get(arr.size() - 1).substring(1);
				String g = Integer.toString(Integer.parseInt(e) + 1) + f;
				arr.add(g);
			}

			else {
				for (int j = 0; j < i; j++) {
					int c = Integer.parseInt(arr.get(arr.size() - 1).substring(0, 1));
					int d = Integer.parseInt(arr.get(arr.size() - 1).substring(2));

					String s = Integer.toString(--c) + "/" + Integer.toString(++d);
					arr.add(s);
					System.out.println(s);
				}
				String e = arr.get(arr.size() - 1).substring(0, 2);
				String f = arr.get(arr.size() - 1).substring(2);
				String g = e + Integer.toString(Integer.parseInt(f) + 1);
				arr.add(g);
			}
		}

	}

}
