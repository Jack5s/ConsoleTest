package recursive;

import java.util.Scanner;

public class Queen {
	private static int count = 0;

	public static void main(String[] args) {
		java.util.Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		queenSolve(n);
		System.out.println(count);
	}

	public static void queenSolve(int n) {
		int[] a = new int[n];
		solve(a, 0, n);
	}

	public static void solve(int[] a, int rowIndex, int n) {
		if (rowIndex < n) {
			int i;
			for (i = 0; i < n; i++) {
				a[rowIndex] = i;
				if (check(a, rowIndex) == false) {
					a[rowIndex] = -1;
				} else {
					solve(a, rowIndex + 1, n);
				}
			}
		} else {
			for (int i = 0; i < n; i++) {				
				System.out.print(String.valueOf(a[i]) + " ");				
			}
			count++;
			System.out.println();
		}
	}

	public static boolean check(int[] a, int i) {
		int k;
		for (k = 0; k < i; k++) {
			if (a[i] == a[k]) {
				return false;
			}
			if (a[i] - i == a[k] - k) {
				return false;
			}
			if (a[i] + i == a[k] + k) {
				return false;
			}
		}
		return true;
	}
}
