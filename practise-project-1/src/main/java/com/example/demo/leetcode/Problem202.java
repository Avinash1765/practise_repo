package com.example.demo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem202 {
	
	 Set<Integer> set= new HashSet<>();

	public static void main(String[] args) {
		Problem202 obj= new Problem202();
		
		obj.isHappy(27);
	}

	public boolean isHappy(int n) {

		while (set.isEmpty() || (!set.contains(n) && n != 1)) {
			set.add(n);

			int next = 0;

			while (n != 0) {
				int dig = n % 10;
				next += (dig * dig);
				n /= 10;
			}
			n = next;
		}

		if (n == 1)
			return true;
		else
			return false;
	}

}
