package com.example.geeks;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class KthSmallestSortedMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.next());
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		System.out.println(kthSmallest(a, n, k));

	}

	private static int kthSmallest(int[][] a, int n, int k) {
		
		Set<String> indexSet = new HashSet<>();

		Queue<Integer> q = new PriorityQueue<>();

		int cnt = 0;

		int i = 0, j = 0;

		while (cnt < k) {

			if (i == n) {
				j++;
				i = 0;
			}
			
			String indexString= new Integer(i).toString().concat(new Integer(j).toString());
			if(!indexSet.contains(indexString)) {
				q.add(a[i][j]);
				indexSet.add(indexString);
			}
			i++;
			cnt++;
		}

		cnt = 0;
		i = 0;
		j = 0;

		while (cnt < k) {

			if (j == n) {
				i++;
				j = 0;
			}
			String indexString= new Integer(i).toString().concat(new Integer(j).toString());
			if(!indexSet.contains(indexString)) {
				q.add(a[i][j]);
				indexSet.add(indexString);
			}
			j++;
			cnt++;
		}

		cnt = 1;

		while (cnt < k) {
			q.poll();
			cnt++;
		}

		return q.peek();

	}

}