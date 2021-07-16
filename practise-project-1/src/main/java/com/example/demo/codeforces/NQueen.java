package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueen {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();

			int arr[][] = new int[n][n];

			List<List<Integer>> sols = new ArrayList<>();

			List<Integer> currentSolution = new ArrayList<>();

			solver(arr, 0, n, currentSolution, sols);

			for (List<Integer> currentSol : sols) {
				System.out.print("[");
				for (Integer ele : currentSol) {
					System.out.print(ele + " ");
				}
				System.out.print("] ");
			}
			System.out.println();
		}
	}

	private static boolean isSafe(int[][] arr, int x, int y, int n) {

		for (int i = 0; i < n; i++) {
			if (arr[x][i] == 1)
				return false;
		}

		for (int i = 0; i < n; i++) {
			if (arr[i][y] == 1)
				return false;
		}

		int l = x, r = y;

		while (l >= 0 && r >= 0) {
			if (arr[l][r] == 1)
				return false;
			l--;
			r--;
		}

		l = x;
		r = y;

		while (l < n && r < n) {
			if (arr[l][r] == 1)
				return false;
			l++;
			r++;
		}

		l = x;
		r = y;

		while (l < n && r < n && l >= 0 && r >= 0) {
			if (arr[l][r] == 1)
				return false;
			l++;
			r--;
		}

		l = x;
		r = y;

		while (l < n && r < n && l >= 0 && r >= 0) {
			if (arr[l][r] == 1)
				return false;
			l--;
			r++;
		}

		return true;
	}

	private static void solver(int[][] arr, int currentCol, int n, List<Integer> currentSolution,
			List<List<Integer>> sols) {
		if (currentCol >= n) {
			sols.add(new ArrayList<>(currentSolution));
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isSafe(arr, i, currentCol, n)) {
				currentSolution.add(i + 1);
				arr[i][currentCol] = 1;
				solver(arr, currentCol + 1, n, currentSolution, sols);
				arr[i][currentCol] = 0;
				currentSolution.remove(currentSolution.size() - 1);
			}
		}
	}

}
