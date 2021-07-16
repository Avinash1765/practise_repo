package com.example.demo.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HamiltonPath {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			int e= s.nextInt();
			
			int edges[][]= new int[n][n];
			
			for(int i=0;i<e;i++) {
				int a= s.nextInt()-1;
				int b= s.nextInt()-1;
				
				edges[a][b]= 1;
				edges[b][a]= 1;
			}
			
			
			
			boolean flag= false;
			
			for(int i=0;i<n;i++) {
				Set<Integer> currentPath= new HashSet<>();
				currentPath.add(i);
				flag = findHamiltonPath(edges, n, i, currentPath);
				if(flag)
					break;
			}
			
			System.out.println(flag ? 1 : 0);
			
			
		}
	}

	private static boolean findHamiltonPath(int[][] edges, int n, int currentNode, Set<Integer> currentPath) {
		if(currentPath.size()==n)
			return true;
		
		for(int i=0;i<n;i++) {
			if(edges[currentNode][i]==1 && !currentPath.contains(i)) {
				currentPath.add(i);
				if(findHamiltonPath(edges, n, i, currentPath)) {
					return true;
				}
				currentPath.remove(i);
			}
		}
		
		return false;
	}

}
