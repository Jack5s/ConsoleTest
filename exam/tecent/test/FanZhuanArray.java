package tecent.test;

import java.util.Scanner;

public class FanZhuanArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong();
		scanner.close();
		int opFlag = -1;
		long flagIndex = 0;
		long sum = 0;
		for (long i = 0; i < n; i++) {
			long value = i + 1;
			if (opFlag == 1) {
				
			} else {
				value =- value;
			}
			sum += value;
			flagIndex++;
			if (flagIndex == m) {
				opFlag = -opFlag;
				flagIndex = 0;
			}
			System.out.print(value + " ");
		}
		System.out.println(sum);
	}
}
