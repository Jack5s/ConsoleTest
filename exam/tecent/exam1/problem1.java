package tecent.exam1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class problem1 {

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String str = bufferedReader.readLine();
		bufferedReader.close();
		bracketSolve(str);
	}

	public static void bracketSolve(String str) {
		int i = 0;
		char[] stack = new char[100000];
		int top = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c == '[') {
				stack[top] = c;
				top++;
				i++;
			} else if (c == ']') {
				int beginIndex = i;
				int endIndex = i;
				while (c != '[') {
					c = stack[top - 1];
					top--;
					beginIndex--;
				}
				String contentStr = str.substring(beginIndex + 1, endIndex);
				int splitIndex = contentStr.indexOf('|');
				String numStr = contentStr.substring(0, splitIndex);
				int num = 0;
				num = Integer.valueOf(numStr);
				String repeatStr = contentStr.substring(numStr.length() + 1, contentStr.length());
				String repeatStrR = "";
				for (int j = 0; j < num; j++) {
					repeatStrR = repeatStrR + repeatStr;
				}
				str = str.substring(0, beginIndex) + repeatStrR + str.substring(endIndex + 1);
				i = beginIndex + repeatStrR.length();
				if (top != 0) {
					for (int j = 0; j < repeatStrR.length(); j++) {
						char cStack = repeatStrR.charAt(j);
						stack[top] = cStack;
						top++;
					}
				}
			} else if (top == 0) {
				i++;
			} else {
				stack[top] = c;
				top++;
				i++;
			}
		}
		System.out.println(str);

	}
}
