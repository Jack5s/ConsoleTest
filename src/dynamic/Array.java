package dynamic;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] strA = scanner.nextLine().split(",");
		scanner.close();
		int[] a = new int[strA.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.valueOf(strA[i]);
		}
		int value = LongestASCCount(a);
		System.out.println(value);
	}

	public static int LongestASCCount(int[] a) {
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		int[] r = new int[n];
		for (int i = 0; i < r.length; i++) {
			r[i] = 1;
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j]) {
					if (r[i] < r[j] + 1) {
						r[i] = r[j] + 1;
					}
				}
			}
		}
		int maxCount = -1;
		for (int i = 0; i < n; i++) {
			if (maxCount < r[i]) {
				maxCount = r[i];
			}
		}
		return maxCount;
	}
}
