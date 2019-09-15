package dynamic;

import java.util.Scanner;

public class Bag {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int count = scanner.nextInt();
//		int maxCost = scanner.nextInt();
//		int[] cost = new int[count];
//		int[] value = new int[count];
//		for (int i = 0; i < count; i++) {
//			cost[i] = scanner.nextInt();
//			value[i] = scanner.nextInt();
//		}
//		scanner.close();
//		dynamic1(cost, value, count, maxCost);
//		dynamicN(cost, value, count, maxCost);

		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] cost1 = new int[count];
		int[] cost2 = new int[count];
		for (int i = 0; i < count; i++) {
			cost1[i] = scanner.nextInt();
			cost2[i] = scanner.nextInt();
		}
		scanner.close();
		int value = maxCount(cost1, cost2, count);
		System.out.println(value);
	}

	public static void dynamic1(int[] cost, int[] value, int count, int maxCost) {
		int[] maxValue = new int[maxCost + 1];
		int j, i;
		for (i = 0; i < count; i++) {
			for (j = maxCost; j >= cost[i]; j--) {
				int currentCost = j - cost[i];
				int currentValue = maxValue[currentCost] + value[i];
				if (maxValue[j] < currentValue) {
					maxValue[j] = currentValue;
				}
			}
		}
		System.out.println(maxValue[maxCost]);
	}

	public static void dynamicN(int[] cost, int[] value, int count, int maxCost) {
		int[] maxValue = new int[maxCost + 1];
		int j, i;
		for (i = 0; i < count; i++) {
			for (j = cost[i]; j <= maxCost; j++) {
				int currentCost = j - cost[i];
				int currentValue = maxValue[currentCost] + value[i];
				if (maxValue[j] < currentValue) {
					maxValue[j] = currentValue;
				}
			}
		}
		System.out.println(maxValue[maxCost]);
	}

	public static void minCount(int[] cost, int count, int maxValue) {
		int[] minCount = new int[maxValue + 1];
		int i, j;
		for (i = 1; i <= maxValue; i++) {
			minCount[i] = Integer.MAX_VALUE - 1;
		}

		for (i = 0; i < count; i++) {
			for (j = cost[i]; j <= maxValue; j++) {
				int currentCost = j - cost[i];
				int currentCount = minCount[currentCost] + 1;
				if (minCount[j] > currentCount) {
					minCount[j] = currentCount;
				}
			}
		}
		int r = minCount[maxValue];
		if (r == Integer.MAX_VALUE - 1) {
			r = -1;
		}
		System.out.println(r);
	}

	public static int maxCount(int[] cost1, int[] cost2, int count) {
		int max1 = -1;
		int max2 = -1;
		for (int i = 0; i < count; i++) {
			if (max1 < cost1[i]) {
				max1 = cost1[i];
			}
			if (max2 < cost2[i]) {
				max2 = cost2[i];
			}
		}
		int[][] r = new int[max1 + 1][max2 + 1];
		int i, j;
		for (int k = 0; k < count; k++) {
			for (i = max1; i >= cost1[k]; i--) {
				for (j = max2; j >= cost2[k]; j--) {
					int currentValue1 = i - cost1[k];
					int currentValue2 = j - cost2[k];
					int currentCount = r[currentValue1][currentValue2] + 1;
					if (r[i][j] < currentCount) {
						r[i][j] = currentCount;
					}
				}
			}
		}
		return r[max1][max2];
	}
}
