package tecent.test;

import java.util.Scanner;

public class Eat {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long m = scanner.nextLong();
		scanner.close();
		long i;
		for (i = 1; i < m + 1; i++) {
			if (check(n, m, i) == false) {
				break;
			}
		}
		System.out.println(i - 1);
	}

	public static boolean check(int n, long m, long r) {
		long sum = r;
		long value = r;
		for (int i = 1; i < n; i++) {
			if (value % 2 == 0) {
				value /= 2;
			} else {
				value /= 2;
				value++;
			}
			if (value == 0) {
				return false;
			}
			sum += value;
		}
		if (sum <= m) {
			return true;
		} else {
			return false;
		}
	}
}
