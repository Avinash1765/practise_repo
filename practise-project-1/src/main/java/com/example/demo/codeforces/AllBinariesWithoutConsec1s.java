package com.example.demo.codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllBinariesWithoutConsec1s {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int k= s.nextInt();
		
		List<String> resultArr= new ArrayList<>();
		
		String currStr= "";
		
		getAllBinaries(currStr, resultArr, k);
		
		resultArr.forEach((str) -> System.out.println(str));
	}

	private static void getAllBinaries(String currStr, List<String> resultArr, int k) {
		if(k<0)
			return;
		
		//boolean res= checkForConsecOnes(currStr);
		
//		if(res)
//			return;
		if(k==0)
			resultArr.add(currStr);
		
		getAllBinaries(currStr.concat("0"), resultArr, k-1);
		
		if(!(!currStr.isEmpty() && currStr.charAt(currStr.length()-1) == '1' ))
			getAllBinaries(currStr.concat("1"), resultArr, k-1);
		
	}

	private static boolean checkForConsecOnes(String currStr) {
		
		if(currStr.length()<2)
			return false;
		
		for(int i=0;i< currStr.length()-1; i++) {
			if(currStr.charAt(i)=='1' && currStr.charAt(i+1)== '1')
				return true;
		}
		
		return false;
	}

}
