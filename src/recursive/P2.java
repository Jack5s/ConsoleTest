package recursive;

import java.util.Scanner;

public class P2 {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		int[] b = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			b[i] = scanner.nextInt();
		}
		scanner.close();
//		getPWithoutRepeatNumber(a, b, 0, n);
		System.out.println(count);
	}

	public static void getPWithoutRepeatNumber(int[] a, int[] b, int index, int n) {
		if (index == n - 1) {

			if (check(a, b, n) == true) {
				count++;
			}
		} else {
			getPWithoutRepeatNumber(a, b, index + 1, n);
			int t;
			for (int i = index + 1; i < n; i++) {
				if (a[index] != a[i]) {
					t = a[index];
					a[index] = a[i];
					a[i] = t;
					getPWithoutRepeatNumber(a, b, index + 1, n);

					t = a[index];
					a[index] = a[i];
					a[i] = t;
				}
			}
		}
	}

	private static boolean check(int[] a, int[] b, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (b[i] == 0) {
				if (a[i] >= a[i + 1]) {
					return false;
				}
			}
			if (b[i] == 1) {
				if (a[i] <= a[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static int Func(int[] b) {
		int mod = 1000000007, n = b.length;
		int[][] a = new int[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++)
				a[i][j] = 0;
		}
		a[0][0] = 1;
		for (int i = 0; i < n; i++) {
			if (b[i] == 0) {
				for (int j = 1; j <= i + 1; j++)
					a[i + 1][j] = (a[i + 1][j - 1] + a[i][j - 1]) % mod;
			} else {
				for (int j = i; j >= 0; j--)
					a[i + 1][j] = (a[i + 1][j + 1] + a[i][j]) % mod;
			}
		}
		int asd = 0;
		for (int i = 0; i <= n; i++)
			asd = (asd + a[n][i]) % mod;
		return asd;
	}
}
