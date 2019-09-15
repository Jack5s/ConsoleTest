package bracket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BackOp {

	public static void main(String[] args) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String strT = bufferedReader.readLine();
			bufferedReader.close();
			int i = 0;
			String[] strArray = strT.split(" ");
			int n = strArray.length;
			Stack<String> stack = new Stack<String>(); 
			int r = 0;
			while (i < n) {
				String str = strArray[i];
				if (isOp(str) == true) {
					int a2 = Integer.valueOf(stack.pop());
					int a1 = Integer.valueOf(stack.pop());
					switch (str) {
					case "+":
						r = a1 + a2;
						break;
					case "-":
						r = a1 - a2;
						break;
					case "*":
						r = a1 * a2;
						break;
					case "/":
						r = a1 / a2;
						break;
					}
					stack.push(String.valueOf(r));
					i++;
				} else {
					stack.push(str);
					i++;
				}
			}
			System.out.println(r);
		} catch (Exception ex) {
		}
	}

	public static boolean isOp(String str) {
		if (str.compareTo("+") == 0 || str.compareTo("-") == 0 || str.compareTo("*") == 0 || str.compareTo("/") == 0) {
			return true;
		} else {
			return false;
		}
	}
}
