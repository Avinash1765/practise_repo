package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

public class IntelligentGirl {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String str=s.next();
		
		
		int ans[]=new int[str.length()];
		
		ans[str.length()-1]= ifEven(str, str.length()-1) ? 1 : 0;
		
		for(int i=str.length()-2;i>=0;i--) {
			if(ifEven(str, i)) {
				ans[i]= ans[i+1] +1;
			}else
				ans[i]=ans[i+1];
		}
		
		//System.out.println(Arrays.toString(ans).substring(1, ans.length-1).replace(',', ' '));
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+" ");
	}
	
	public static boolean ifEven(String str, int index) {
		
		return str.charAt(index) == '2' || str.charAt(index) == '4' ||str.charAt(index) == '6' ||str.charAt(index) == '8'; 
		//return Integer.parseInt(str.substring(index))%2==0;
	}

}
