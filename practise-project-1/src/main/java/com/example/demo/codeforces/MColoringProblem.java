package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MColoringProblem {
	
	static int v;
	public static void main(String[] args) {
		
		
		Scanner s= new Scanner(System.in);
		
		v= s.nextInt();
		int c= s.nextInt();
		int e= s.nextInt();
		
		List<Integer>[] edges= new ArrayList[v];
		
		for(int i=0;i<e;i++) {
			int src= s.nextInt()-1;
			int dest= s.nextInt()-1;
			
			edges[src].add(dest);
			edges[dest].add(src);
		}
		
		int finalColor[]= new int[v];
		
		graphColoring(edges, finalColor, 0, c);
	
	}
	
	private static boolean checkIfColorAssign(List<Integer>[] edges, int[] finalColors, int currentVertex, int c) {
		return false;
	}
	
    public static boolean graphColoring(List<Integer>[] edges, int[] finalColors, int currentVertex, int c) {
    	if(currentVertex >= v) {
    		return true;
    	}
    	
    	for(int i=0;i<v;i++) {
    		
    	}
    	
    	return false;
    }


}
