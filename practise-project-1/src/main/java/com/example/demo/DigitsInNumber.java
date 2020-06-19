package com.example.demo;

import java.math.BigInteger;
import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitsInNumber {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		
		List<BigInteger> list=new ArrayList<>();
		long n=3;
		
		list.add(new BigInteger("3"));
		
		for(int i=1;i<15;i++) {
			n*=3;
			list.add(list.get(i-1).add(BigInteger.valueOf(n)));
		}
		
		//System.out.println(list);
		
		
		
		
		while(t-->0) {
			BigInteger val=new BigInteger(s.next());
			int numDig= 0;
			//int w=3;
			if(val.subtract(new BigInteger("3")).signum() ==-1) {
				numDig=1;
			}else {
				numDig=search(list,val)+2;
			}
			System.out.println(numDig);
			
		}
	}

	private static int search(List<BigInteger> list, BigInteger val) {
		int l=0, r=list.size()-1;
		
		while(l<=r && l<list.size() && r<list.size()) {
			int mid= l + (r-l)/2;
			
			if(list.get(mid).equals(val) || (val.subtract(list.get(mid)).signum()==1 && list.get(mid+1).subtract(val).signum()==1))
				return mid;
			else if(list.get(mid).subtract(val).signum()==-1) {
				l= mid+1;
			}else {
				r=mid-1;
			}
		}
		
		return -1;
	}

}
