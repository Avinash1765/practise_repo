package com.example.demo.codeforces;

import java.util.Scanner;

public class Buttons {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		
		int ans=0, j=0;
		
		for(int i=n;i>=1;i--) {
			ans+= i;
			
			ans+= (j * (i-1));
			j++;
		}
		
		System.out.println(ans);
	}

}
