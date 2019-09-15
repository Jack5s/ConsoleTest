package recursive;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class P {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int lineCount = scanner.nextInt();

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < lineCount; i++) {
			String str = scanner.nextLine();
			String[] strA = str.split(" ");
			TreeNode node = new TreeNode();
			node.nodeCount = Integer.valueOf(strA[0]) - 1;
			node.key = Integer.valueOf(strA[1]);
			list.add(node.key);
			for (int j = 2; j < strA.length; j++) {
				TreeNode childNode = new TreeNode();
				childNode.key = Integer.valueOf(strA[j]);
				list.add(node.key);
			}
		}

	}

	public static class TreeNode {
		int nodeCount = 0;
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		int key;
	}

	

}
