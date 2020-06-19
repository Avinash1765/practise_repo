package com.example.demo;

import java.util.Scanner;

public class MonkandKundan {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String baseString = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int t=s.nextInt();
		s.nextLine();
		while(t-->0) {
			int count=0;
			int finalCount=0;
			
			String str= s.nextLine();
			String arr[]=str.split(" ");
			int size= arr.length;
			
			for(String st: arr) {
				count=0;
				for(int i=0;i<st.length();i++) {
					count+= i+ getPos(st.charAt(i));
				}
				finalCount+= size*count;
			}
			System.out.println(finalCount);
		}
	}

	private static int getPos(char ch) {
		if(Character.isLowerCase(ch))
			return ch-97;
		else if(Character.isUpperCase(ch))
			return ch-65+36;
		else
			if(ch != '0')
				return ch-48+25;
			else
				return 35;
	}

}
