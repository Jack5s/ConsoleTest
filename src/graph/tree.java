package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class tree {
	public static void main(String[] args) throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strList = new ArrayList<String>();
		String str = bufferedReader.readLine();
		while (str.length() > 0) {
			strList.add(str);
			str = bufferedReader.readLine();
		}
		bufferedReader.close();

		for (String strValue : strList) {
			String[] strArray = strValue.split(" ");
			int n = strArray.length;
			Part[] a = new Part[n];
			a[0] = new Part();
			a[0].value = Integer.valueOf(strArray[0]);
			a[0].rootIndex = 0;
			a[0].count = 1;
			for (int i = 1; i < n; i++) {
				a[i] = new Part();
				a[i].value = Integer.valueOf(strArray[i]);
				a[i].count = 1;
				int minIndex = 9999;
				for (int j = 0; j < i; j++) {
					if (isCon(a[i].value, a[j].value) == true) {
						if (a[j].rootIndex < minIndex) {
							minIndex = a[j].rootIndex;
						}
					}
				}

				if (minIndex == 9999) {
					a[i].rootIndex = i;
				} else {
					a[i].rootIndex = minIndex;
				}
				if (minIndex != 9999) {
					a[minIndex].count++;
					boolean[] flag = new boolean[n];
					for (int j = 0; j < i; j++) {
						if (isCon(a[i].value, a[j].value) == true) {
							if (minIndex != a[j].rootIndex && flag[a[j].rootIndex] == false) {
								flag[a[j].rootIndex] = true;
								a[minIndex].count += a[a[j].rootIndex].count;
								a[j].rootIndex = minIndex;
							}
						}
					}
				}
				int aa = 0;
				aa = 0;
			}
			if (a[0].count == n) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
		}
	}

	private static boolean isCon(int a, int b) {
		if ((a / 10 - b / 10 == 0) && (Math.abs(a % 10 - b % 10) == 1)) {
			return true;
		} else if ((Math.abs(a / 10 - b / 10) == 1) && (a % 10 == b % 10)) {
			return true;
		} else {
			return false;
		}
	}

}

class Part {
	int value = 0;
	int rootIndex = -1;
	int count;

	Part() {
	}
}