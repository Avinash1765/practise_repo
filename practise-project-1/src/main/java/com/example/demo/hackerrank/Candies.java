package com.example.demo.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Candies {

	 static long candies(int n, int[] arr) {
		 	long ans=0;
		 	long dp[]= new long[n];
		 	Arrays.fill(dp, 1);
		 	
	        List<Map.Entry<Integer, Integer>> list= new ArrayList<>();
			
			Map<Integer, Integer> map= new HashMap<>();
			
			
			for(int i=0;i<n;i++)
				map.put(i, arr[i]);
			
			list.addAll(map.entrySet());
			
			Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

				@Override
				public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
					return (a.getValue() - b.getValue());
				}
			});
			
			for(Map.Entry<Integer, Integer> entry : list) {
			//	int curEle= entry.getKey();
				int curInd= entry.getKey();
				
				long leftVal= ((curInd==0 || arr[curInd] <= arr[curInd-1]) ? 0 : dp[curInd-1]);
				long rightVal= ((curInd == n-1 || arr[curInd] <= arr[curInd+1]) ? 0 : dp[curInd+1]);
				
				dp[curInd]= Math.max(leftVal, rightVal) +1;
				ans+= dp[curInd];
			}
			
			return ans;

	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	    	//Scanner scanner= n

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        int[] arr = new int[n];

	        for (int i = 0; i < n; i++) {
	            int arrItem = scanner.nextInt();
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
	            arr[i] = arrItem;
	        }

	        long result = candies(n, arr);
	        System.out.println(result);

//	        bufferedWriter.write(String.valueOf(result));
//	        bufferedWriter.newLine();
//
//	        bufferedWriter.close();

	        scanner.close();
	    }
}
