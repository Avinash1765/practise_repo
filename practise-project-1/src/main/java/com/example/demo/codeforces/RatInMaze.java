package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RatInMaze {
	
	 
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int arr[][]= new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]= s.nextInt();
			}
		}
		
		List<String> allPaths = printPath(arr, n);
		
		for(String path: allPaths) {
			System.out.println(path);
		}
	}

	private static List<String> printPath(int[][] arr, int n) {
		
		List<String> paths= new ArrayList<>();
		boolean visited[][]= new boolean[n][n];
		
		StringBuilder currentPath= new StringBuilder();
		
		printPathUtil(arr, n, 0, 0, paths, currentPath, visited);
		
		return paths;
	}
	
	private static boolean isSafe(int[][] arr, int i, int j, int n, boolean[][] visited) {
		return (i>=0 && j>=0 && i<n && j<n && !visited[i][j] && arr[i][j]==1);
	}

	private static boolean printPathUtil(int[][] arr, int n, int l, int r, List<String> paths, StringBuilder currentPath, boolean[][] visited) {
		if(l==n-1 && r== n-1)
			return true;
		
		visited[l][r]= true;
		
		if(isSafe(arr, l, r+1, n, visited)) {
			currentPath.append('R');
			
			if(printPathUtil(arr, n, l, r+1, paths, currentPath, visited)) {
				visited[l][r]= false;
				paths.add(currentPath.toString());
			//	return true;
				
			}else {
				currentPath.delete(currentPath.length()-1, currentPath.length());
			}
		}
		
		if(isSafe(arr, l+1, r, n, visited)) {
			currentPath.append('D');
			
			if(printPathUtil(arr, n, l+1, r, paths, currentPath, visited)) {
				visited[l][r]= false;
				paths.add(currentPath.toString());
			//	return true;
				
			}else {
				currentPath.delete(currentPath.length()-1, currentPath.length());
			}
		}
		
		return false;
	}

}
