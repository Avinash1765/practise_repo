package com.example.demo.codeforces;

import java.util.Scanner;

public class SubSetSumProblemDP {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = s.nextInt();

		System.out.println(equalPartition(n, arr));
		s.close();
	}

	private static int equalPartition(int n, int[] arr) {

		int totalSum = 0;

		for (int i = 0; i < n; i++)
			totalSum += arr[i];

		if (totalSum % 2 == 1)
			return 0;

		int actSum = totalSum / 2;

		boolean[][] dp = new boolean[n][actSum + 1];

		int prefixSum[] = new int[n];
		prefixSum[0] = arr[0];

		for (int i = 0; i < n; i++) {
			dp[i][0] = true;

			if (i >= 1)
				prefixSum[i] = prefixSum[i - 1] + arr[i];
		}

		for (int i = 1; i <= actSum; i++)
			dp[0][i] = (arr[0] == i);

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= actSum; j++) {

				if (j > prefixSum[i])
					break;

				dp[i][j] = dp[i - 1][j] || ((j - arr[i] < 0) ? false : dp[i-1][j - arr[i]]);

				/*
				 * boolean flag= (j - arr[i] < 0 ? false : dp[i][j - arr[i]]);
				 * 
				 * if(flag) break;
				 */

				if (j == actSum && dp[i][j]) {
					for (int w = 0; w < n; w++) {

						System.out.print(w + " ");
						for (int y = 1; y <= actSum; y++) {
							if (dp[w][y])
								System.out.print(y + " ");
						}
						System.out.println();
					}

					return 1;
				}
			}
		}

		return 0;
	}

}
