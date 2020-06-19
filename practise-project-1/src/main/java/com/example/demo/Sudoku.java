package com.example.demo;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) {
		int arr[][]=new int[9][9];
		Scanner s=new Scanner(System.in);
		//int n=s.nextInt();
	//	while(n-->0) {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				arr[i][j]= s.nextInt();
			}
		}
		solveSudoku(arr);
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(arr[i][j]+" ");
			}
		
		}
		
		
	}

	private static boolean solveSudoku(int[][] arr) {
		int row=0,col=0;
		boolean returnFlag=true;
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(arr[i][j]==0) {
					returnFlag=false;
					row=i;
					col=j;
					break;
				}
			}
			if(!returnFlag)
				break;
		}
		if(returnFlag)
			return true;
		
		
		
			for(int start=1;start<=9;start++) {
					if(findSafeNumber(arr, row, col,start)) {
						arr[row][col]=start;
						if(solveSudoku(arr))
							return true;
						else
							arr[row][col]=0;
					}
				
			}
		
		return false;
	}

	private static boolean findSafeNumber(int[][] arr, int x, int y,int starter) {
		
			return findIfCorrect(arr,starter,x,y);
	
	}

	private static boolean findIfCorrect(int[][] arr, int val, int x, int y) {
		
		for(int i=0;i<9;i++) {
			if(arr[x][i]==val) 
				return false;
		}
		
		for(int i=0;i<9;i++) {
			if(arr[i][y]==val) 
				return false;
		}
		
		int a=(x/3)*3;
		int b=(y/3)*3;
		
		int pos1[]= {0,0,0,1,1,1,2,2,2};
		int pos2[]= {0,1,2,0,1,2,0,1,2};
		
		for(int i=0;i<9;i++) {
			if(arr[a+pos1[i]][b+pos2[i]]==val)
				return false;
		}
		
		return true;
	}
	
	

}
