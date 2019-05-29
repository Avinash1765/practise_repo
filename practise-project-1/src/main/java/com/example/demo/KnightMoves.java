package com.example.demo;

import java.util.Scanner;

public class KnightMoves {
	static boolean visited[][]=new boolean[11][11];
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x= s.nextInt();
		int y=s.nextInt();
		int moves=s.nextInt();
		
		int sol=countPossibleMoves(x,y,moves);
		
		
		System.out.println(sol-1);
	}

	private static int countPossibleMoves(int x, int y, int moves) {
		int sol=0;
		int arr[][]=new int[11][11];
		countMovesUtil(arr,x,y,moves);
		
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=10;j++) {
				if(visited[i][j])
					sol++;
			}
		}
		return sol;
	}

	private static void countMovesUtil(int[][] arr, int x, int y, int moves) {
		if(x<=0 || y>=11 || x>=11 || y<=0  || moves<0)
			return;
		else if(moves==0) {
			visited[x][y]=true;
		    return;
		}
		else {
			//visited[x][y]=true;
			countMovesUtil(arr, x+2, y+1, moves-1);
			countMovesUtil(arr, x+1, y+2, moves-1);
			countMovesUtil(arr, x+2, y-1, moves-1);
			countMovesUtil(arr, x-2, y+1, moves-1);
			countMovesUtil(arr, x-1, y-2, moves-1);
			countMovesUtil(arr, x-2, y-1, moves-1);
			countMovesUtil(arr, x-1, y+2, moves-1);
			countMovesUtil(arr, x+1, y-2, moves-1);
		}
	}

}
