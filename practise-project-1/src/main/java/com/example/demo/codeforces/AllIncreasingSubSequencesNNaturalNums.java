package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllIncreasingSubSequencesNNaturalNums {
	
	static List<List<Integer>> finalAns= new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int k= s.nextInt();
		
		List<Integer> currentList= new LinkedList<>();
		
		printAllIncreasingSequences(n, k, currentList, 1);
		
		for(List<Integer> item: finalAns) {
			for(Integer ele: item) {
				System.out.print(ele+" ");
			}
			System.out.println();
		}
		
	}

	private static void printAllIncreasingSequences(int n, int k, List<Integer> currentList, int index) {
		
		if(currentList.size() > k) {
			return;
		}
		
		if(currentList.size()== k) {
			finalAns.add(new ArrayList<>(currentList));
			return;
		}
		
		for(int i= index; i<= n; i++) {
			currentList.add(i);
			
			printAllIncreasingSequences(n, k, currentList, i+1);
			
			currentList.remove(currentList.size() - 1);

		}
		
	}
}
