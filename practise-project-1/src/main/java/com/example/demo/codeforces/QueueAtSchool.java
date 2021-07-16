package com.example.demo.codeforces;

import java.util.Scanner;

public class QueueAtSchool {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int t= s.nextInt();
		
		String str= s.next();
		
		for(int i=0; i< n-1;i++) {
			if(str.charAt(i) == 'B') {
				int j, maxComeBackPos;
				
				for( j= i+1; j<n ; j++) {
					if(str.charAt(j) == 'B')
						break;
				}
				
				maxComeBackPos = Math.min(j-i, t);
				
				if(maxComeBackPos > 0) {
					
				}
				else {
					i=j;
				}
				
			}
		}
	}

}
