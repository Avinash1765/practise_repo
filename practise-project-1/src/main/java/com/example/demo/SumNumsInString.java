package com.example.demo;

public class SumNumsInString {
	static int finalSum;
	static int sum;
	public static void main(String[] args) {
		String str="a23bcf87a1";
		sumInString(str);
		finalSum+=sum;
		System.out.println(finalSum);
	}

	private static void sumInString(String str) {
		
		for(int i=0;i<str.length();i++) {
			if(Character.isDigit(str.charAt(i))){
				updateSum(str.charAt(i));
			}
			else 
				updateSum();
		}
		
	}

	private static void updateSum(char... charArray) {
		if(charArray.length==1) {
		int dig=Integer.parseInt(Character.toString(charArray[0]));
		sum*=10;
		sum+=dig;
	}
		else {
			finalSum+=sum;
			sum=0;
		}
	}
}
