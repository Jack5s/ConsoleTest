package dynamic;

import java.util.Scanner;

public class StringMatch {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int aLength = scanner.nextInt();
//		int bLength = scanner.nextInt();
//		scanner.nextLine();
		char[] a = scanner.nextLine().toCharArray();
		char[] b = scanner.nextLine().toCharArray();
		scanner.close();
		longestDiscreteString(a, b);
	}

	public static void longestDiscreteString(char[] a, char[] b) {
		int aLength = a.length;
		int bLength = b.length;
		int[][] dp = new int[aLength + 1][bLength + 1];
		for (int i = 1; i <= aLength; i++) {
			for (int j = 1; j <= bLength; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
				}
			}
		}
		System.out.println(dp[aLength][bLength]);
	}

	public static int minimumOpCount(char[] a, char[] b) {
		int aLength = a.length;
		int bLength = b.length;
		int[][] dp = new int[aLength][bLength];
		for (int i = 0; i <= aLength; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= bLength; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= aLength; i++) {
			for (int j = 1; j <= bLength; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[aLength][bLength];
	}

}
