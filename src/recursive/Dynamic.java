package recursive;

import java.util.Scanner;

public class Dynamic {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int maxWeight = scanner.nextInt();
		int[] weight = new int[count];
		int[] value = new int[count];
		for (int i = 0; i < count; i++) {
			weight[i] = scanner.nextInt();
			value[i] = scanner.nextInt();
		}
		scanner.close();
		System.out.println(dynamic1(weight, value, 0, 0, maxWeight));
		boolean[] usedFlag = new boolean[count];
		System.out.println(dynamicN(weight, value, 0, 0, maxWeight, usedFlag));
	}

	public static int dynamic1(int[] weight, int[] value, int currentWeight, int currentValue, int maxWeight) {
		int maxValue = currentValue;
		for (int i = 0; i < weight.length; i++) {
			if (currentWeight + weight[i] <= maxWeight) {
				int rValue = dynamic1(weight, value, currentWeight + weight[i], currentValue + value[i], maxWeight);
				if (maxValue < rValue) {
					maxValue = rValue;
				}
			}
		}
		return maxValue;
	}

	public static int dynamicN(int[] weight, int[] value, int currentWeight, int currentValue, int maxWeight,
			boolean[] usedFlag) {
		int maxValue = currentValue;
		for (int i = 0; i < weight.length; i++) {
			if (currentWeight + weight[i] <= maxWeight && usedFlag[i] == false) {
				usedFlag[i] = true;
				int rValue = dynamicN(weight, value, currentWeight + weight[i], currentValue + value[i], maxWeight,
						usedFlag.clone());
				if (maxValue < rValue) {
					maxValue = rValue;
				}
			}
		}
		return maxValue;
	}
}
