package tecent.exam1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class problem4 {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		scanner.close();

		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String str = bufferedReader.readLine();
			bufferedReader.close();
		} catch (Exception e) {
		}
	}

}
