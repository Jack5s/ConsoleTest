package array;
import java.util.Scanner;

public class Plus {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] strA = str.split(" ");
		char[] a = strA[0].toCharArray();
		char[] b = strA[1].toCharArray();
		int n = a.length;
		int m = b.length;
		scanner.close();

		for (int i = 0; i < n / 2; i++) {
			char t = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = t;
		}
		for (int i = 0; i < m / 2; i++) {
			char t = b[i];
			b[i] = b[m - i - 1];
			b[m - i - 1] = t;
		}

		int len = 0;
		if (n > m) {
			len = n + 1;
		} else {
			len = m + 1;
		}
		int[] r = new int[len];
		for (int i = 0; i < m && i < n; i++) {
			r[i] = r[i] + a[i] + b[i] - 96;
		}
		if (n > m) {
			for (int i = m; i < n; i++) {
				r[i] = r[i] + a[i] - 48;
			}
		} else {
			for (int i = n; i < m; i++) {
				r[i] = r[i] + b[i] - 48;
			}
		}
		for (int i = 0; i < len; i++) {
			if (r[i] >= 10) {				
				r[i + 1] += r[i] / 10;
				r[i] %= 10;
			}
		}
		int index = len - 1;
		for (index = len - 1; index >= 0; index--) {
			if (r[index] != 0) {
				break;
			}
		}
		for (int i = index; i >= 0; i--) {
			System.out.print(r[i]);
		}
	}
}
