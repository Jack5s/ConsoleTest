package tecent.test;

import java.util.Scanner;

public class PaintColor {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		char[][] a = new char[n][m];
//		char[][] r = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = scanner.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j);
			}
		}
		scanner.close();
		long step = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char c = a[i][j];
				if (c == 'Y' || c == 'G') {
					step++;
//					System.out.println(i + " " + j+" "+step);
					int i2 = i;
					int j2 = j;
					while (i2 < n && j2 < m) {
						if (a[i2][j2] == 'Y') {
							a[i2][j2] = 'X';
						}else	if (a[i2][j2] == 'G') {
							a[i2][j2] = 'B';
						}
						else {
							break;
						}
						i2++;
						j2++;
					}
//					print(a, n, m);
				}				
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				char c = a[i][j];
				if (c == 'B') {
					step++;
//					System.out.println(i + " " + j+" "+step);
					int i2 = i;
					int j2 = j;
					while (i2 < n && j2 >= 0) {
						if (a[i2][j2] == 'B') {
							a[i2][j2] = 'X';
						}
						else {
							break;
						}
						i2++;
						j2--;
					}
//					print(a, n, m);
				}
			}
		}

		System.out.println(step);
	}

//	public static void print(char[][] a, int n, int m) {
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < m; j++) {
//				System.out.print(a[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
