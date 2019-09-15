import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();

		int[] r = new int[n];
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = a[i];
			count[i] = 1;
		}

		for (int i = n - 3; i >= 0; i--) {
			int minCount = count[i + 2];
			for (int j = i + 2; j < n; j++) {
				int value = r[j] + a[i];
				if (r[i] <= value) {
					r[i] = value;
					if (minCount > count[j]) {
						minCount = count[j];
					}
				}
			}
			if (a[i] > 0) {
//				r[i] = maxValue;
				count[i] = minCount + 1;
			} else {
//				r[i] = maxValue;
				count[i] = minCount;
			}
		}
		if (r[0] > r[1]) {
			System.out.print(r[0] + " ");
			System.out.print(count[0]);
		} else if (r[0] == r[1]) {
			System.out.print(r[0] + " ");
			if (count[1] < count[0]) {
				System.out.print(count[1]);
			} else {
				System.out.print(count[0]);
			}
		} else {
			System.out.print(r[1] + " ");
			System.out.print(count[1]);
		}
	}
}
