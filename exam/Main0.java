import java.util.Scanner;

public class Main0 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = scanner.nextInt();
			}
		}
		scanner.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && a[j][i] == 0) {
					a[i][j] = 0;
				}
			}
		}

		boolean[] flag = new boolean[n];
		Integer k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && flag[i] == false && flag[j] == false) {
					getFirends(a, i, flag, n);
					k++;
				}
			}
		}
		System.out.println(k);
	}

	private static void getFirends(int[][] a, int index, boolean[] flag, int n) {
		flag[index] = true;
		for (int i = 0; i < n; i++) {
			if (flag[i] == false) {
				if (a[index][i] == 1 && a[i][index] == 1) {
					getFirends(a, i, flag, n);
				}
			}
		}
	}
}
