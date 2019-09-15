package tecent.exam1;

import java.util.Scanner;

public class problem3 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long l = scanner.nextLong();
		int[] x = new int[n];
		int[] y = new int[n];
		boolean[] usedFlag = new boolean[n];
		for (int i = 0; i < n; i++) {
			x[i] = scanner.nextInt();
			y[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(-1);
	}

	public static int solve(long pos, boolean[] usedFlag, long l, int[] x, int[] y, int n) {
		int min = 99999;
		for (int i = 0; i < n; i++) {
			if (usedFlag[i] == false) {
				if (y[i] < pos) {
					continue;
				}
				usedFlag[i] = true;
				pos = y[i];
				if (pos >= l) {
					return 1;
				}

				int r = solve(pos, usedFlag.clone(), l, x, y, n);
				if (min > r) {
					min = r;
				}
			}
		}
		return min;
	}
}
