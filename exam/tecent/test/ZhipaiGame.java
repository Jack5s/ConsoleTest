package tecent.test;

import java.util.Arrays;
import java.util.Scanner;

public class ZhipaiGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextLong();
		}
		scanner.close();

		Arrays.parallelSort(a);
		long sum = 0;
		int flag = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (flag == 1) {
				sum += a[i];
			} else {
				sum -= a[i];
			}
			flag = -flag;
		}
		System.out.println(sum);
	}

}
