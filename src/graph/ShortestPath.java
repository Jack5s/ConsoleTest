package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortestPath {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] e = new int[10][10];
		int n = scanner.nextInt();
		scanner.close();
		int k, i, j;

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i == j) {
					e[i][j] = 0;
				} else
					e[i][j] = Integer.MAX_VALUE;
			}
		}
		for (k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (e[i][j] > e[i][k] + e[k][j]) {
						e[i][j] = e[i][k] + e[k][j];
					}
				}
			}
		}
	}

	public static void Dijkstra(int[][] a, int n) {
		int[] minDis = new int[n];
		boolean[] hasReach = new boolean[n];
		int i, j;
		for (i = 0; i < n; i++) {
			minDis[i] = a[0][i];
		}

		hasReach[0] = true;
		for (i = 1; i < n; i++) {
			int minIndex = 0;
			int min = Integer.MAX_VALUE;
			for (j = 0; j < n; j++) {
				if (hasReach[j] == false && minDis[j] < min && minDis[j] > 0) {
					min = minDis[j];
					minIndex = j;
				}
			}
			hasReach[minIndex] = true;
			for (j = 0; j < n; j++) {
				if (hasReach[j] == false) {
					if (a[minIndex][j] > 0) {
						if (minDis[j] > minDis[minIndex] + a[minIndex][j] || minDis[j] <= 0) {
							minDis[j] = minDis[minIndex] + a[minIndex][j];
						}
					}
				}
			}
		}
		for (i = 1; i < n; i++) {
			System.out.println(minDis[i]);
		}
	}

	public void floyd(int[][] a, int n, int[][] path, int[][] dist) {
		int inf = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = a[i][j];
				path[i][j] = j;
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int tmp = (dist[i][k] == inf || dist[k][j] == inf) ? inf : (dist[i][k] + dist[k][j]);
					if (dist[i][j] > tmp) {
						dist[i][j] = tmp;
						path[i][j] = path[i][k];
					}
				}
			}
		}

		System.out.printf("floyd: \n");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(dist[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
