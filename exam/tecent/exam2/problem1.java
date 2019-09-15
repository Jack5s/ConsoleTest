package tecent.exam2;

import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scanner.nextLong();
		}
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			b[i] = scanner.nextLong();
		}
		scanner.close();

		int jishuA = 0;
		int oushuA = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] % 2 == 0) {
				oushuA++;
			} else {
				jishuA++;
			}
		}

		int jishuB = 0;
		int oushuB = 0;
		for (int i = 0; i < m; i++) {
			if (a[i] % 2 == 0) {
				oushuB++;
			} else {
				jishuB++;
			}
		}

		int v1 = 0;
		int v2 = 0;
		if (jishuA > oushuB) {
			v1 = oushuB;
		} else {
			v1 = jishuA;
		}

		if (oushuA > jishuB) {
			v2 = jishuB;
		} else {
			v2 = oushuA;
		}
		System.out.println(v1 + v2);
	}
}
