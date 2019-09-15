package bracket;

import java.util.Scanner;

public class RemoveBracket2 {
	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String str = scanner.nextLine();
//		scanner.close();
		String str = "D((AC)2B)2(ADC)2E";
		String r = solveStringInBracket(str);
		System.out.println(r);
	}

	private static String solveStringInBracket(String str) {
		int i = 0;
		char c = ' ';
//		String r = str;
		while (i < str.length()) {
			c = str.charAt(i);
			if (c == '(') {
				String content = getStringInBracket(str, i);
				int endIndex = i + content.length() + 2;
				String contentR = solveStringInBracket(content);
				String strR = contentR;
				String numStr = getNumberString(str, endIndex);
				int num = Integer.valueOf(numStr);
				for (int j = 1; j < num; j++) {
					strR += contentR;
				}
				str = str.substring(0, i) + strR + str.substring(endIndex + 1);
//				System.out.println(str);
			} else if (c == ')') {

			} else {
			}
			i++;
		}
		return str;
	}

	private static String getStringInBracket(String str, int index) {
		int i = index;
		int count = 0;
		char c = ' ';
		while (i < str.length()) {
			c = str.charAt(i);
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			} else {
			}
			if (count == 0) {
				break;
			}
			i++;
		}
		return str.substring(index + 1, i);
	}

	private static String getNumberString(String str, int index) {
		int i = index;
		char c = ' ';
		while (i < str.length()) {
			c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				i++;
			} else {
				break;
			}
		}
		return str.substring(index, i);
	}
}
