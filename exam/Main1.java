import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c == '(') {
				str = delContent(str, i);
				continue;
			}
			if (c == '<') {
				if (i - 1 >= 0) {
					str = str.substring(0, i - 1) + str.substring(i + 1);
					i--;
					continue;
				} else {
					str = str.substring(1);
					continue;
				}
			}
			i++;
		}
		System.out.println(str);
	}

	private static String delContent(String str, int index) {
		int flagCount = 1;
		int i = index + 1;
		while (flagCount != 0) {
			char c = str.charAt(i);
			if (c == '(') {
				flagCount++;
			}
			if (c == ')') {
				flagCount--;
			}
			i++;
		}
		return str.substring(0, index) + str.substring(i);
	}
}
