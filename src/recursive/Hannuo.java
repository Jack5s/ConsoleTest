package recursive;

import java.util.Scanner;

public class Hannuo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		solve('1', '2', '3', n);
	}

	public static void solve(char x, char y, char z, int n) {
		if (n == 1) {
			print(x, z);
		} else {
			solve(x, z, y, n - 1);
			print(x, z);
			solve(y, x, z, n - 1);
		}
	}

	public static void print(char a, char b) {
		System.out.print(a + "->" + b);
		System.out.println();
	}
}
