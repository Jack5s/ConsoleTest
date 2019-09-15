package tecent.exam2;

import java.util.Scanner;

public class problem5 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
		}
		scanner.close();
		for (int i = 0; i < n; i++) {
			int value = getR(a[i], b[i], k);
			System.out.println(value);
		}
	}

	public static int getR(int a, int b, int k) {
		if (k > b) {
			return b - a + 1;
		} else {
			int count = 0;
			if (k <= a) {
				for (int i = a; i <= b; i++) {
					count += solve(i, k);
				}
				return count;
			} else {
				for (int i = k; i <= b; i++) {
					count += solve(i, k);
				}
				return count + k - a;
			}

		}
	}

	public static int solve(int maxCount, int k) {
		int count = 0;
		int i = k;
		while (i <= maxCount) {
			int t = 0;
			int j = i;
			while (j <= maxCount + 1) {
				t ++;
				j += (k + 1);
			}
			count += maxCount - i + 1;

			i += k;
		}
		return count + 1;
	}

}
