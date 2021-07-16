package com.example.demo.codeforces;

import java.util.Scanner;

public class CheapTravel {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		int a= s.nextInt();
		int b= s.nextInt();
		
		boolean flag= (a <= (b/m));
		
		if(flag) {
			System.out.println(a*n);
		}else {
			int numTripsWithBulkTicket= n/m;
			int ans = numTripsWithBulkTicket * b;
			
			int remainTrips = n%m;
			
			if(remainTrips* a <= b)
				ans += (remainTrips * a);
			else
				ans+= b;
			System.out.println(ans);
		}
	}

}
