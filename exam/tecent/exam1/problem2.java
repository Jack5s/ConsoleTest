package tecent.exam1;

import java.util.Scanner;

public class problem2 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int num = 1;
		for (int i = 0; i < n; i++) {
			num *= 2;
		}
		int[] a = new int[num];
		for (int i = 0; i < num; i++) {
			a[i] = scanner.nextInt();
		}

		int m = scanner.nextInt();
		int[] q = new int[m];
		for (int i = 0; i < m; i++) {
			int times = 1;
			int numM = scanner.nextInt();
			for (int j = 0; j < numM; j++) {
				times *= 2;
			}
			q[i] = times;
		}
		scanner.close();

		for (int i = 0; i < q.length; i++) {
			reverse(a, q[i], num);
			int r = pair(a, 0, num);
			System.out.println(r);
		}

	}

	public static void reverse(int[] a, int n, int num) {

		int[] t = new int[n];
		for (int i = 0; i < num; i += n) {
			for (int j = 0; j < n; j++) {
				t[n - j - 1] = a[i + j];
			}
			for (int j = 0; j < n; j++) {
				a[i + j] = t[j];
			}
		}
	}

	public static int pair(int[] a, int index, int num) {
		if (index >= num - 1) {
			return 0;
		} else {
			int sum = 0;
			for (int i = index + 1; i < num; i++) {
				if (a[i] < a[index]) {
					sum += 1;
				}
			}
			sum += pair(a, index + 1, num);
			return sum;
		}
	}
}