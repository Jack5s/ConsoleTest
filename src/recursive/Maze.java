package recursive;

import java.util.Scanner;

public class Maze {
	public static void main(String[] args) {
		java.util.Scanner scanner = new Scanner(System.in);
		int rowCount = scanner.nextInt();
		int columnCount = scanner.nextInt();
		int k = scanner.nextInt();
		int[][] maze = new int[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				maze[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
		
		int maxValue = 0;
		int[][] mazeR = new int[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				mazeR[i][j] = mazeMaxK(maze, rowCount, columnCount, i, j, k, mazeR);
				if (maxValue < mazeR[i][j]) {
					maxValue = mazeR[i][j];
				}
			}
		}
		System.out.println(maxValue);
	}

	public static int mazeMaxK(int[][] maze, int rowCount, int columnCount, int i, int j, int k, int[][] mazeR) {
		int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
		if (k > 0) {
			if (j + 1 < columnCount) {
				if (maze[i][j + 1] >= maze[i][j]) {
					v1 = mazeMaxK(maze, rowCount, columnCount, i, j + 1, k - 1, mazeR);
				} else {
					v1 = mazeMaxK(maze, rowCount, columnCount, i, j + 1, k, mazeR);
				}
			}
			if (i + 1 < rowCount) {
				if (maze[i + 1][j] >= maze[i][j]) {
					v2 = mazeMaxK(maze, rowCount, columnCount, i + 1, j, k - 1, mazeR);
				} else {
					v2 = mazeMaxK(maze, rowCount, columnCount, i + 1, j, k, mazeR);
				}
			}
			if (j - 1 >= 0) {
				if (maze[i][j - 1] >= maze[i][j]) {
					v3 = mazeMaxK(maze, rowCount, columnCount, i, j - 1, k - 1, mazeR);
				} else {
					v3 = mazeMaxK(maze, rowCount, columnCount, i, j - 1, k, mazeR);
				}
			}
			if (i - 1 >= 0) {
				if (maze[i - 1][j] >= maze[i][j]) {
					v4 = mazeMaxK(maze, rowCount, columnCount, i - 1, j, k - 1, mazeR);
				} else {
					v4 = mazeMaxK(maze, rowCount, columnCount, i - 1, j, k, mazeR);
				}
			}
		} else {
			if (j + 1 < columnCount) {
				if (maze[i][j + 1] < maze[i][j]) {
					v1 = mazeMaxK(maze, rowCount, columnCount, i, j + 1, 0, mazeR);
				}
			}
			if (i + 1 < rowCount) {
				if (maze[i + 1][j] < maze[i][j]) {
					v2 = mazeMaxK(maze, rowCount, columnCount, i + 1, j, 0, mazeR);
				}
			}
			if (j - 1 >= 0) {
				if (maze[i][j - 1] < maze[i][j]) {
					v3 = mazeMaxK(maze, rowCount, columnCount, i, j - 1, 0, mazeR);
				}
			}
			if (i - 1 >= 0) {
				if (maze[i - 1][j] < maze[i][j]) {
					v4 = mazeMaxK(maze, rowCount, columnCount, i - 1, j, 0, mazeR);
				}
			}
		}
		return max(v1, v2, v3, v4) + 1;
	}

	public static int max(int v1, int v2, int v3, int v4) {
		int max = v1;
		if (max < v2) {
			max = v2;
		}
		if (max < v3) {
			max = v3;
		}
		if (max < v4) {
			max = v4;
		}
		return max;
	}

	public static int mazeMin(int[][] maze, int rowCount, int columnCount, int i, int j, int[][] mazeR) {
		if (mazeR[i][j] == 0) {
			return mazeR[i][j];
		}
		int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
		if (j + 1 < columnCount) {
			v1 = mazeMin(maze, rowCount, columnCount, i, j + 1, mazeR);
		}
		if (i + 1 < rowCount) {
			v2 = mazeMin(maze, rowCount, columnCount, i + 1, j, mazeR);
		}
		if (j - 1 >= 0) {
			v3 = mazeMin(maze, rowCount, columnCount, i, j - 1, mazeR);
		}
		if (i - 1 >= 0) {
			v4 = mazeMin(maze, rowCount, columnCount, i - 1, j, mazeR);
		}
		int value = min(v1, v2, v3, v4) + maze[i][j];
		mazeR[i][j] = value;
		return value;
	}

	public static int min(int v1, int v2, int v3, int v4) {
		int min = v1;
		if (min > v2 && v2 > 0) {
			min = v2;
		}
		if (min > v3 && v3 > 0) {
			min = v3;
		}
		if (min > v4 && v4 > 0) {
			min = v4;
		}
		return min;
	}

	public static int mazeMinWithoutBorder(char[][] maze, int n, boolean[][] flag, int i, int j, int[][] mazeR) {
		if (mazeR[i][j] == 0) {
			if (maze[i][(j + 1) % n] == 'E') {
				mazeR[i][(j + 1) % n] = 1;
				return 1;
			}

			if (maze[(i + 1) % n][j] == 'E') {
				mazeR[(i + 1) % n][j] = 1;
				return 1;
			}

			if (maze[i][(j - 1 + n) % n] == 'E') {
				mazeR[i][(j - 1 + n) % n] = 1;
				return 1;
			}
			if (maze[(i - 1 + n) % n][j] == 'E') {
				mazeR[(i - 1 + n) % n][j] = 1;
				return 1;
			}

			int v1 = -1, v2 = -1, v3 = -1, v4 = -1;
			if (maze[i][(j + 1) % n] == '.' && flag[i][(j + 1) % n] == false) {
				if (i == 0 && (j + 1) % n == 3) {
					int a;
					a = 1;
				}
				flag[i][(j + 1) % n] = true;
				v1 = mazeMinWithoutBorder(maze, n, flag, i, (j + 1) % n, mazeR);
				flag[i][(j + 1) % n] = false;
			}

			if (maze[(i + 1) % n][j] == '.' && flag[(i + 1) % n][j] == false) {
				flag[(i + 1) % n][j] = true;
				v2 = mazeMinWithoutBorder(maze, n, flag, (i + 1) % n, j, mazeR);
				flag[(i + 1) % n][j] = false;
			}

			if (maze[i][(j - 1 + n) % n] == '.' && flag[i][(j - 1 + n) % n] == false) {
				flag[i][(j - 1 + n) % n] = true;
				v3 = mazeMinWithoutBorder(maze, n, flag, i, (j - 1 + n) % n, mazeR);
				flag[i][(j - 1 + n) % n] = false;
			}
			if (maze[(i - 1 + n) % n][j] == '.' && flag[(i - 1 + n) % n][j] == false) {
				flag[(i - 1 + n) % n][j] = true;
				v4 = mazeMinWithoutBorder(maze, n, flag, (i - 1 + n) % n, j, mazeR);
				flag[(i - 1 + n) % n][j] = false;
			}

			int value = min(v1, v2, v3, v4) + 1;
			if (value == 0) {
				return -1;
			}
			return value;
		} else {
			return mazeR[i][j];
		}
	}
}
