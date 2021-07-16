package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllSortedArraysFromSortedArrays {

	static List<List<Integer>> finalAns = new LinkedList<>();

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int i = s.nextInt();
		int a[] = new int[i];

		int j = s.nextInt();
		int b[] = new int[j];

		for (int ind = 0; ind < i; ind++)
			a[ind] = s.nextInt();

		for (int ind = 0; ind < j; ind++)
			b[ind] = s.nextInt();

		List<Integer> currentList = new LinkedList<>();

		findAllSortedElementsAltEle(a, b, i, j, 0, 0, true, currentList);

		for (List<Integer> item : finalAns) {
			for (Integer ele : item) {
				System.out.print(ele + " ");
			}
			System.out.println();
		}

	}

	private static void findAllSortedElementsAltEle(int[] a, int[] b, int i, int j, int currI, int currJ, boolean flag,
			List<Integer> currentList) {
		
//		if((flag && currI >= i) || (!flag && currJ >= j)) {
//			return;
//		}
	
		//finalAns.add(new ArrayList<>(currentList));
		
		if(flag) {
			if(currentList.size() >0)
				finalAns.add(new ArrayList<>(currentList));
			
			for(int ind= currI; ind < i; ind++) {
				if(!currentList.isEmpty() && currentList.get(currentList.size()-1) >= a[ind])
					continue;
				
				currentList.add(a[ind]);
				findAllSortedElementsAltEle(a, b, i, j, ind+1, currJ, !flag, currentList);
				currentList.remove(currentList.size()-1);
			}
		}
		else {
			for(int ind= currJ; ind < j; ind++) {
				if(currentList.get(currentList.size()-1) >= b[ind])
					continue;
				
				currentList.add(b[ind]);
				findAllSortedElementsAltEle(a, b, i, j, currI, ind+1, !flag, currentList);
				currentList.remove(currentList.size()-1);
			}
		}
	}

}
