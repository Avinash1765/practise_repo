package com.example.demo.codeforces;

import java.util.Scanner;

public class Problem1382B {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int t= s.nextInt();
		while(t-->0) {
			int n= s.nextInt();
			
			int arr[]= new int[n];
			for(int i=0;i<n;i++)
				arr[i]= s.nextInt();
			
			int turn=0;
			boolean currentPileHalfProcessedFlag= false;
			
			System.out.println(game(arr, 0, turn, n, currentPileHalfProcessedFlag)==0 ? "First" : "Second");
		}
	}

	private static int game(int[] arr, int ind, int turn, int n, boolean currentPileFlag) {
		
		int lastTurn=-1;
		
		if(ind>=n)
			return (turn+1)%2;
		
		if(arr[ind]==1)
			return game(arr, ind+1, (turn+1)%2, n, false);
		
		if(!currentPileFlag)
			lastTurn= game(arr, ind, (turn+1)%2, n, true);
		int lastTurn2=game(arr, ind+1, (turn+1)%2, n, false);
		
		if(lastTurn==1 || lastTurn2==1)
			return 0;
		else 
			return 1;
		
	}

}
