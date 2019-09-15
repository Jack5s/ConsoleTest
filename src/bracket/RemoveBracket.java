package bracket;

import java.util.Scanner;

public class RemoveBracket {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		String value = getNumberString(str, 3);
		System.out.println(value);
//		solveStringInBracket(str);
	}

	private static void solveStringInBracket(String str) {
		int i = 0;
		char c = ' ';
		while (i < str.length()) {
			c = str.charAt(i);
			if (c == '(') {
				String str1 = getStringInBracket(str, i);
				System.out.println(str1);
			} else if (c == ')') {

			} else {
			}
			i++;
		}
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
