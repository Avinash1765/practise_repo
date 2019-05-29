package com.example.demo;

import java.util.Scanner;

public class TwoGroups {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		
		while(t-->0) {
			int n=s.nextInt();
			System.out.println(calculatePower(2, n));
		}
	}
	
	static long calculatePower(long x, long y) {
        int mod = 1_000_000_007;
        long res = 1;     // Initialize result
 
        while (y > 0) {
            // If y is odd, multiply x with result
            if ((y & 1)!=0)
                res = (res * x)%mod;
 
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x)%mod; // Change x to x^2
        }
        return (res-2+mod)%mod;
    }

}
