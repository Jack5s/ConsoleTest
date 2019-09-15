package tree;

import java.util.Scanner;

import sun.font.CreatedFontTracker;

public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String first = scanner.nextLine();
		String medium = scanner.nextLine();
//		String last = scanner.nextLine();
		scanner.close();

		TreeNode root = createTreeLFromFM(first, medium);
//		TreeNode root = createTreeLFromML(medium, last);
		firstOreder(root);
		System.out.println();
		mediumOreder(root);
		System.out.println();
		lastOreder(root);
		System.out.println();
	}

	public static TreeNode createTreeLFromFM(String first, String medium) {
		if (medium.length() == 0) {
			return null;
		}
		TreeNode root = new TreeNode();
		root.key = first.charAt(0);
		int i;
		for (i = 0; i < medium.length(); i++) {
			if (medium.charAt(i) == root.key) {
				break;
			}
		}
		String firstLeftStr = first.substring(1, i + 1);
		String mediumLeftStr = medium.substring(0, i);

		String firstRightStr = first.substring(i + 1);
		String mediumRightStr = medium.substring(i + 1);

		root.left = createTreeLFromFM(firstLeftStr, mediumLeftStr);
		root.right = createTreeLFromFM(firstRightStr, mediumRightStr);

		return root;
	}

	public static TreeNode createTreeLFromML(String medium, String last) {
		if (medium.length() == 0) {
			return null;
		}
		TreeNode root = new TreeNode();
		root.key = last.charAt(last.length() - 1);
		int i;
		for (i = 0; i < medium.length(); i++) {
			if (medium.charAt(i) == root.key) {
				break;
			}
		}
		String mediumLeftStr = medium.substring(0, i);
		String lastLeftStr = last.substring(0, i);

		String mediumRightStr = medium.substring(i + 1);
		String lastRightStr = last.substring(i, last.length() - 1);

		root.left = createTreeLFromML(mediumLeftStr, lastLeftStr);
		root.right = createTreeLFromML(mediumRightStr, lastRightStr);

		return root;
	}

	public static void firstOreder(TreeNode root) {
		if (root != null) {
			System.out.print(root.key);
			firstOreder(root.left);
			firstOreder(root.right);
		}
	}

	public static void mediumOreder(TreeNode root) {
		if (root != null) {
			mediumOreder(root.left);
			System.out.print(root.key);
			mediumOreder(root.right);
		}
	}

	public static void lastOreder(TreeNode root) {
		if (root != null) {
			lastOreder(root.left);
			lastOreder(root.right);
			System.out.print(root.key);
		}
	}
//
//	public TreeNode createTreeLFromFMSolve(String[] firstOrderArray, String[] mediumOrderArray) {
//		TreeNode treeNode = new TreeNode();
//		treeNode.key = firstOrderArray[0];
//
//		return treeNode;
//	}
}
