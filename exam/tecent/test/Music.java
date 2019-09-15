package tecent.test;

import java.util.Scanner;

public class Music {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int aLength = scanner.nextInt();
		int aCount = scanner.nextInt();
		int bLength = scanner.nextInt();
		int bCount = scanner.nextInt();
		scanner.close();
		System.out.println((getCount(aLength, aCount, bLength, bCount, k) % 1000000007));
	}

	public static long getCount(int aLength, int aCount, int bLength, int bCount, int k) {
		if (k == aLength) {
			return aCount;
		}
		if (k == bLength) {
			return bCount;
		}
		if (k <= 0 || aCount == 0 || bCount == 0) {
			return 0;
		} else {
			long a = getCount(aLength, aCount - 1, bLength, bCount, k - aLength);
			long b = getCount(aLength, aCount, bLength, bCount - 1, k - bLength);
			return a + b + aCount + bCount - 1;
		}
	}
}
