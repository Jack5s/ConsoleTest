package tecent.exam2;

import java.util.Scanner;

public class problem2 {
	private static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
		}
		scanner.close();
		getP(0, n, a, b);
		System.out.println(min);
	}

	public static void getP(int index, int n, int[] a, int[] b) {
		if (index >= n) {
			int value = getR(a, b, n);
			if (min > value) {
				min = value;
			}
		} else {
			getP(index + 1, n, a, b);
			int t;
			for (int i = index + 1; i < n; i++) {
				t = a[index];
				a[index] = a[i];
				a[i] = t;

				t = b[index];
				b[index] = b[i];
				b[i] = t;
				getP(index + 1, n, a, b);
				
				t = a[index];
				a[index] = a[i];
				a[i] = t;

				t = b[index];
				b[index] = b[i];
				b[i] = t;				
			}
		}
	}

	public static int getR(int[] a, int[] b, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i] * i;
			sum += b[i] * (n - i - 1);
		}
		return sum;
	}
}
