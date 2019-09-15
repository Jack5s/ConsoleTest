package search;

public class KMP {

	public static void main(String[] args) {
		System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
	}

	public static int[] getNextArray(char[] t) {
		int[] next = new int[t.length];
		next[0] = -1;
		next[1] = 0;
		int k;
		for (int j = 2; j < t.length; j++) {
			k = next[j - 1];
			while (k != -1) {
				if (t[j - 1] == t[k]) {
					next[j] = k + 1;
					break;
				} else {
					k = next[k];
				}
				next[j] = 0;
			}
		}
		return next;
	}

	public static int kmpMatch(String s, String t) {
		char[] str = s.toCharArray();
		char[] matchStr = t.toCharArray();
		int[] next = getNextArray(matchStr);
		int i = 0, j = 0;
		while (i < str.length && j < matchStr.length) {
			if (j == -1 || str[i] == matchStr[j]) {
				i++;
				j++;
			} else
				j = next[j];
		}
		if (j == matchStr.length)
			return i - j;
		else
			return -1;
	}

}
