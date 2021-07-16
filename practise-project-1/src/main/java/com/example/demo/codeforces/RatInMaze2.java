package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class RatInMaze2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int arr[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		List<String> allPaths = printPath(arr, n);

		for (String path : allPaths) {
			System.out.println(path);
		}
	}

	private static List<String> printPath(int[][] arr, int n) {

		List<String> paths = new ArrayList<>();
		boolean visited[][] = new boolean[n][n];

		String currentPath = new String();

		printPathUtil(arr, n, 0, 0, paths, currentPath, visited);

		paths.sort(new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				return a.compareTo(b);
			}

		});
		return paths;
	}

	private static boolean isSafe(int[][] arr, int i, int j, int n, boolean[][] visited) {
		return (i >= 0 && j >= 0 && i < n && j < n && arr[i][j] == 1 && !visited[i][j]);
	}

	private static void printPathUtil(int[][] arr, int n, int l, int r, List<String> paths, String currentPath,
			boolean[][] visited) {
		if (l == n - 1 && r == n - 1) {
			paths.add(currentPath.toString());
			return;
		}

		if (!isSafe(arr, l, r, n, visited))
			return;

		visited[l][r]= true;
		printPathUtil(arr, n, l, r + 1, paths, currentPath.concat(new Character('R').toString()), visited);
		printPathUtil(arr, n, l + 1, r, paths, currentPath.concat(new Character('D').toString()), visited);
		printPathUtil(arr, n, l, r-1, paths, currentPath.concat(new Character('L').toString()), visited);
		printPathUtil(arr, n, l -1, r, paths, currentPath.concat(new Character('U').toString()), visited);

		visited[l][r]= false;
	}

}
