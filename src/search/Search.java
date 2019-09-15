package search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Search {
	public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
//		
//		int n = 6;
//		int searchNum = 19;
//		int[] a = new int[n];
//		
//		for (int i = 0; i < n; i++) {
//			a[i] = scanner.nextInt();
//		}
//		scanner.close();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = bufferedReader.readLine();
		String[] strArray = str.substring(1, str.length() - 1).split(",");
		int n = strArray.length;
		int[] a = new int[n];
		int searchNum = 19;
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strArray[i]);
		}

		System.out.println(binarySearch(a, 0, n, searchNum) + 1);
	}

	public static int binarySearch(int[] a, int minIndex, int maxIndex, int num) {
		int k = (minIndex + maxIndex) / 2;
		if (minIndex > maxIndex) {
			return -1;
		}
		if (a[k] == num) {
			return k;
		} else if (a[k] > num) {
			return binarySearch(a, minIndex, k - 1, num);
		} else {
			return binarySearch(a, k + 1, maxIndex, num);
		}
	}
}
