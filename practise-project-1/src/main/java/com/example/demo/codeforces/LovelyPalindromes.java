package com.example.demo.codeforces;

import java.util.Scanner;

public class LovelyPalindromes {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String str= s.next();
		
		StringBuilder finalAns= new StringBuilder();
		
		int insertIndex=0;
		
		for(char c: str.toCharArray()) {
			if(finalAns.length() ==0) {
				finalAns.append(c);
				finalAns.append(c);
			}else {
				String d= new String(new Character(c).toString());
				d=d.concat(new Character(c).toString());
				
				finalAns.insert(++insertIndex, d);
			}
		}
		
		System.out.println(finalAns);
	}

}
