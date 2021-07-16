package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SumTriangle {

	static List<List<Integer>> finalAns = new LinkedList<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		int arr[] = new int[n];

		for (int ind = 0; ind < n; ind++)
			arr[ind] = s.nextInt();

		List<Integer> currentList = new ArrayList<>();
		extractSumT(arr, n, 0, currentList);

		for (List<Integer> item : finalAns) {
			for (Integer ele : item) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}
	}

	private static void extractSumT(int[] arr, int n, int level, List<Integer> currList) {

		if (level >= n)
			return;

		if (level == 0) {
			for (int i = 0; i < n; i++)
				currList.add(arr[i]);
			finalAns.add(new ArrayList<>(currList));

			extractSumT(arr, n, level + 1, new ArrayList<>());
			return;
		}

		List<Integer> prevList = new ArrayList<>(finalAns.get(level - 1));

		for (int i = 0; i < prevList.size() - 1; i++) {
			currList.add(prevList.get(i) + prevList.get(i + 1));
		}

		finalAns.add(new ArrayList<>(currList));
		extractSumT(arr, n, level + 1, new ArrayList<>());

	}

}
