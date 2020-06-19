package com.example.demo;

import java.util.HashSet;

public class PowerSet {
	static HashSet<String> finalSet=new HashSet<>();
	public static void main(String[] args) {
		String str="abc";
		boolean arr[]=new boolean[3];
		
		/*for(int i=0;i<3;i++)
			arr[i]=true;*/
		
		permute(str,arr,0);
	}

	private static void permute(String str, boolean vis[], int len) {
		
		if(len == str.length()) {
			StringBuilder finalString=new StringBuilder();
			for(int i=0;i<str.length();i++) {
				if(vis[i])
					finalString.append(str.charAt(i));
			}
			System.out.println(finalString);
			return;
		}
		
		vis[len]= true;
		permute(str, vis, len+1);
		
		vis[len]=false;
		permute(str, vis, len+1);
		
		
	}

}
