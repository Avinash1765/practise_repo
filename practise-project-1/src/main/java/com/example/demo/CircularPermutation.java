package com.example.demo;

import java.util.Scanner;
import java.util.Stack;

public class CircularPermutation {

	static Stack<StringBuilder> stack=new Stack<>();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long a=s.nextLong();
		
		String bitString=Long.toBinaryString(a);
		
		findNextItems(new StringBuilder(bitString), 1);
	}

	private static void findNextItems(StringBuilder bitString, int index) {
		
		stack.push(bitString);
		
		findNextItems(bitString, index+1);
		
		setOppositeChar(bitString, index);
		
		findNextItems(bitString, index+1);
		
		
		
		
	}

	private static void setOppositeChar(StringBuilder bitString, int index) {
		char ch= bitString.charAt(index);
		if(ch=='0')
			bitString.setCharAt(index, '1');
		else
			bitString.setCharAt(index, '0');
	}

}
