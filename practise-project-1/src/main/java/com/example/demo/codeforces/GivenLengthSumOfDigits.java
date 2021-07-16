package com.example.demo.codeforces;

import java.util.Scanner;

public class GivenLengthSumOfDigits {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int m=s.nextInt();
		int st= s.nextInt();
		
		if((st > 9*m) || (st==0 && m>1)) {
			System.out.println("-1 -1");
		}else if(m==2 && st==1){
			System.out.println("10 10");
		}else {
			String large=getLargest(m, st);
			String small=getSmallest(m, st);
			
			System.out.println(small+" "+ large);
		}
	}

	private static String getSmallest(int m, int s) {
		StringBuilder maxNum= new StringBuilder();
		
		while(m-->0) {
			
			int val = (s<=9 ? s : 9);
			maxNum.append(new Integer(val));
			s-= val;
		}
		
		boolean lastCharReplaced = false;
		
		if(maxNum.charAt(maxNum.length()-1) == '0') {
			maxNum.replace(maxNum.length()-1, maxNum.length(), "1");
			lastCharReplaced= true;
		}
		
		if(lastCharReplaced) {
			int lastNonZeroInd = -1;
			
			int i=0;
			for( ; i< maxNum.length();i++) {
				if(maxNum.charAt(i) == '0')
					break;
			}
			if(i== maxNum.length()) {
				i= maxNum.length()-1;
			}
			maxNum.replace(i-1, i, new Integer(new Integer(Character.toString(maxNum.charAt(i-1))).intValue()-1).toString());
		}
		
		return maxNum.reverse().toString();
	}

	private static String getLargest(int m, int s) {
		StringBuilder maxNum= new StringBuilder();
		
		while(m-->0) {
			int val = (s<=9 ? s : 9);
			maxNum.append(new Integer(val));
			s-= val;
		}
		
		return maxNum.toString();
	}

}
