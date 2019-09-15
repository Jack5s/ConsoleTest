package bracket;

import java.util.Scanner;
import java.util.Stack;

public class bracket {
	public static void main(String[] args) {
//		java.util.Scanner scanner = new Scanner(System.in);
////		int n = scanner.nextInt();
//		scanner.close();

		String str = "D((AC)2B)2(ADC)2E";
//		str = "ABC(AC)005DD";
		int n = str.length();
		String rStr = bracketSolve(str, n);
		System.out.println(rStr);
	}

	public static String bracketSolve(String str, int n) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while (i < n) {
			char c = str.charAt(i);
			if (c == '(') {
				stack.push(c);
				i++;
			} else if (c == ')') {
				int beginIndex = i;
				int endIndex = i;
				while (stack.pop() != '(') {
					beginIndex--;
				}
				beginIndex--;
				String repeatStr = str.substring(beginIndex + 1, endIndex);
				String numStr = getNum(str, endIndex + 1);
				int num = Integer.valueOf(numStr);
				String repeatStrR = "";
				for (int j = 0; j < num; j++) {
					repeatStrR += repeatStr;
				}
				str = str.substring(0, beginIndex) + repeatStrR + str.substring(endIndex + numStr.length() + 1);
				i = beginIndex + repeatStrR.length();
				for (int j = 0; j < repeatStrR.length(); j++) {
					char rc=repeatStrR.charAt(j);
					stack.push(rc);
				}
			} else {
				stack.push(c);
				i++;
			}
		}
		return str;
	}

	public static String getNum(String str, int index) {
		int i = index;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				i++;
			} else {
				break;
			}
		}
		if (i == str.length()) {
			return str.substring(index);
		} else {
			return str.substring(index, i);
		}
	}
}
