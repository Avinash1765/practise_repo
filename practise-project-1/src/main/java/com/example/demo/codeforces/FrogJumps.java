package com.example.demo.codeforces;

import java.util.Scanner;

public class FrogJumps {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int t= s.nextInt();
		
		while(t-->0) {
			
			String str= s.next();
			int n= str.length();
			
			char[] arr= new char[n+1];

			for(int i=1;i<=n;i++)
				arr[i]= str.charAt(i-1);
			arr[0]= 'R';
			
			int l=1, r= n+1, ans=0;
			
			while(l<=r) {
				int mid= (l+r)/2;
				
				boolean vis[]= new boolean[n+1];
				
				boolean flag=check(mid, vis, arr, 0, n);
				
				if(flag) {
					r= mid-1;
					ans= mid;
				}else
					l= mid+1;
			}
			
			System.out.println(ans);
		}
		
	}

	private static boolean check(int d, boolean vis[], char[] arr, int currPos, int n) {
		if(currPos>= n+1)
			return true;
		
		if(vis[currPos])
			return false;
		
		vis[currPos]= true;
		
		if(arr[currPos]=='R') {
			for(int i= currPos +1; i <= currPos+d; i++) {
				if(check(d, vis, arr, i, n))
					return true;
			}
		}
		
		if(arr[currPos]=='L') {
			for(int i= currPos -1; i >= Math.max(currPos-d, 0); i--) {
				if(check(d, vis, arr, i, n))
					return true;
			}
		}
			
		return false;
	}

}
