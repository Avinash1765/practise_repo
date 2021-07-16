package com.example.demo.codeforces;

import java.util.Scanner;

public class SolveSudoku {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		// int n= s.nextInt();
		int arr[][] = new int[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		solveSudoku(arr);
	}

	private static boolean isSafe(int grid[][], int l, int r, int val) {

		for (int i = 0; i < 9; i++) {
			if (grid[i][r] == val)
				return false;
		}

		for (int i = 0; i < 9; i++) {
			if (grid[l][i] == val)
				return false;
		}

		int boxRow = (l / 3) * 3;
		int boxCol = (r / 3) * 3;

		for (int i = boxRow; i < boxRow + 3; i++) {
			for (int j = boxCol; j < boxCol + 3; j++) {
				if (grid[i][j] == val)
					return false;
			}
		}

		return true;
	}

	private static void solveSudoku(int grid[][]) {

		boolean userFill[][] = new boolean[9][9];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] == 0)
					userFill[i][j] = true;
			}
		}

		/*
		 * int l = 0, r = 0; while (!userFill[l][r]) { int nextCol = (r + 1) < 9 ? r + 1
		 * : 0; int nextRow = (nextCol == 0) ? l + 1 : l;
		 * 
		 * l= nextRow; r= nextCol; }
		 */
		solveSudokUtil(grid, 0, 0, userFill);
		printGrid(grid);

	}

	private static void printGrid(int grid[][]) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static boolean solveSudokUtil(int[][] grid, int l, int r, boolean[][] userFill) {
		if ((9 * l) + r > 80)
			return true;
		
		if(r>=9) {
			l+=1;
			r=0;
		}
		
		if(!userFill[l][r]) {
			return solveSudokUtil(grid, l, r+1, userFill);
		}

		for (int val = 1; val <= 9; val++) {
			if (isSafe(grid, l, r, val)) {
				grid[l][r] = val;

				if (solveSudokUtil(grid, l, r+1, userFill)) {
					return true;
				}

				grid[l][r] = 0;
			}
		}

		return false;
	}

}
