	package com.example.demo;
	
	import java.util.Scanner;
	
	public class Upup {
	
		public static void main(String[] args) {
			Scanner s=new Scanner(System.in);
			
			String st= s.nextLine();
			StringBuilder str=new StringBuilder(st);
			int len=str.length();
			str.setCharAt(0, Character.toUpperCase(str.charAt(0)));
			for(int i=-1; (i= str.indexOf(" ", i))!=-1;) {
				int j=i+1;
				while(j<len && Character.isWhitespace(st.charAt(j))) {
					j++;
				}
				if(j<len)
					str.setCharAt(j, Character.toUpperCase(str.charAt(j)));
				i=j;
			}
			System.out.println(str);
		}
	
	}
