package com.example.demo.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem753A {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		Set<Integer> set= new HashSet<>();
		fn(n, set);
		System.out.println(set.size());
		
		set.stream().forEach(c -> System.out.print(c+" "));
	}

	private static boolean fn(int n, Set<Integer> set) {
		if(n<0)
			return false;
		if(n==0)
			return true;
		
		int val=1;
		
		while(val<=n) {
			if(!set.contains(val)) {
				set.add(val);
				if(fn(n-val, set))
					return true;
				else {
					set.remove(val);
				}
			}
			val++;
		}
		return false;
	}

}
