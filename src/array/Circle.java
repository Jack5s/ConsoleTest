package array;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		boolean[] a = new boolean[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = true;
		}
		int t = 0, len = a.length;
		while (len > 1) {
			for (int i = 0; i < a.length; i++) {
				if (a[i]) {
					t++;
					if (t == 3) {
						t = 0;
						a[i] = false;
						len--;
					}
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i]) {
				System.out.println(i + 1);
			}
		}
	}
}
