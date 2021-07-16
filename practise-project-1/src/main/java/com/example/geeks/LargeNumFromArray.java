package com.example.geeks;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LargeNumFromArray {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String arr[]= new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=s.next();
		}
		
		System.out.println(printLargest(arr));
		s.close();
	}

	private static String printLargest(String[] arr) {
		List<String> ar=Arrays.asList(arr);
		
		Collections.sort(ar, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				
//				String str1= a.concat(b);
//				String str2= b.concat(b);
//				
////				BigInteger num1 = new BigInteger(str1);
////				BigInteger num2 = new BigInteger(str2);
//				
//				while()
				
				// logic is to check if (ab) (ba) which is great that will stay at left in array
				return 0;
			}
		});

		StringBuilder finalString = new StringBuilder();
		
		ar.forEach(item -> {
			finalString.append(item);
		});
		
		return finalString.toString();
	}

}
