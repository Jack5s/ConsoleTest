package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumSpanningTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] e = new int[10][10];
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.close();
		int k, i, j;

		int inf = Integer.MAX_VALUE;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i == j) {
					e[i][j] = 0;
				} else
					e[i][j] = inf;
			}
		}
	}

	public static void prim(int[][] graph, int n) {
		int inf = Integer.MAX_VALUE;
		int[] lowcost = new int[n];
		int[] mst = new int[n];

		for (int i = 1; i < n; i++) {
			lowcost[i] = graph[0][i];
			mst[i] = 0;
		}

		int sum = 0;
		for (int i = 1; i < n; i++) {
			int min = inf;
			int minIndex = 0;
			for (int j = 1; j < n; j++) {
				if (lowcost[j] < min && lowcost[j] != 0) {
					min = lowcost[j];
					minIndex = j;
				}
			}

			sum += min;
			lowcost[minIndex] = 0;

			for (int j = 1; j < n; j++) {
				if (graph[minIndex][j] < lowcost[j]) {
					lowcost[j] = graph[minIndex][j];
					mst[j] = minIndex;
				}
			}
		}
		System.out.println("sum:" + sum);
	}

	public void kruskal(Edge[] edgeArray, int edgeCount, int vertexCount) {
		int index = 0;
		int[] rootArray = new int[vertexCount];
		Edge[] result = new Edge[edgeCount];

		ArrayList<Edge> edgeList = (ArrayList<Edge>) Arrays.asList(edgeArray);
		Collections.sort(edgeList, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight > o2.weight ? 1 : -1;
			}
		});
		edgeArray = (Edge[]) edgeList.toArray();

		for (int i = 0; i < edgeCount; i++) {
			int startIndex = edgeArray[i].start;
			int endIndex = edgeArray[i].end;

			int startRoot = getRoot(rootArray, startIndex);
			int endRoot = getRoot(rootArray, endIndex);
			if (endRoot != startRoot) {
				rootArray[endRoot] = startRoot;
				result[index++] = edgeArray[i];
			}
		}

		int totalWeight = 0;
		for (int i = 0; i < index; i++) {
			totalWeight += result[i].weight;
		}
		System.out.println(totalWeight);
	}

	private static int getRoot(int start2end[], int i) {
		while (start2end[i] != 0)
			i = start2end[i];
		return i;
	}
}

class Edge {
	int start;
	int end;
	int weight;
};
