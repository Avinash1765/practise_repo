package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1042B {
	
	static long finalCost=Long.MAX_VALUE;

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		Map<String, Integer> vitaminCostMap= new HashMap<>();
		
		for(int i=0;i<n;i++) {
			int cost= s.nextInt();
			char arr[]= s.next().toCharArray();
			Arrays.sort(arr);
			vitaminCostMap.computeIfPresent(new String(arr), (k, val) -> Math.min(val, cost));
			vitaminCostMap.computeIfAbsent(new String(arr), (k) -> cost);
		}
		
		int[] finalCostArr= new int[7];
		String[] vitaminArr= new String[7];
		int size=0;
		
		for(Map.Entry<String, Integer> entry : vitaminCostMap.entrySet()) {
			finalCostArr[size]= entry.getValue();
			vitaminArr[size]= entry.getKey();
			size++;
		}

		getFinalCost(finalCostArr, size, 0, "", 0, vitaminArr);
		System.out.println(finalCost == Long.MAX_VALUE ? -1 : finalCost);
	}

	private static void getFinalCost(int[] finalCostArr, int size, int ind, String currentVitamins, 
			int currentVitaminCost, String[] vitaminArr) {
		
		if(ind >= size) {
			if(currentVitamins.contains("A") && currentVitamins.contains("B") && currentVitamins.contains("C")) 
				finalCost= Math.min(currentVitaminCost, finalCost);
			return;
		}
		
		getFinalCost(finalCostArr, size, ind+1, currentVitamins+vitaminArr[ind], 
				currentVitaminCost+ finalCostArr[ind], vitaminArr);
		
		getFinalCost(finalCostArr, size, ind+1, currentVitamins, 
				currentVitaminCost, vitaminArr);

	}

}
