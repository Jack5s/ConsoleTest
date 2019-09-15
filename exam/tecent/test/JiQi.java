package tecent.test;

import java.util.Scanner;

public class JiQi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		int[] mTime=new int[n];
		int[] mLevel=new int[n];
		int[] qTime=new int[m];
		int[] qLevel=new int[m];
		for (int i = 0; i < n; i++) {
			mTime[i]=scanner.nextInt();
			mLevel[i]=scanner.nextInt();
		}
		for (int i = 0; i < n; i++) {
			qTime[i]=scanner.nextInt();
			qLevel[i]=scanner.nextInt();
		}
		
		scanner.close();
	}
	
	public static void dynamic1(int[] weight, int[] value, int count, int maxWeight) {
		int[] maxValue = new int[maxWeight + 1];
		int j, i;
		for (i = 0; i < count; i++) {
			for (j = maxWeight; j >= weight[i]; j--) {
				int currentWeight = j - weight[i];
				if (currentWeight >= 0) {
					int currentValue = maxValue[currentWeight] + value[i];
					if (maxValue[j] < currentValue) {
						maxValue[j] = currentValue;
					}
					if (currentWeight == 0) {
					}
				}
			}
		}
		System.out.println(maxValue[maxWeight]);
	}

}
