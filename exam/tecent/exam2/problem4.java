package tecent.exam2;

import java.util.Scanner;

public class problem4 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextLong();
		}
		scanner.close();
		long max = -999;
		for (int i = 0; i < n; i++) {
			for (int j = i ; j < n; j++) {
				long value = getR(a, n, i, j);
				if (max < value) {
					max = value;
				}
			}
		}
		System.out.println(max);
	}

	private static long getR(long[] a, int n, int startIndex, int endIndex) {
		long sum = 0;
		long min = Long.MAX_VALUE;
		for (int i = startIndex; i <= endIndex; i++) {
			sum += a[i];
			if (min > a[i]) {
				min = a[i];
			}
		}
		return sum * min;
	}
}
