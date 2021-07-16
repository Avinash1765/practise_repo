package com.example.demo.codeforces;

import java.util.Scanner;

public class AllSubsets {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str = s.next();

		StringBuilder ans = new StringBuilder();

		//printer(str, ans, 0, str.length(), 2);
	}

	private static void printer(String str, StringBuilder ans, int i, int n, int k) {

		if(ans.length()== k)
			System.out.println(ans);

		for (int ind = i; ind < n; ind++) {
			ans.append(str.charAt(ind));

			printer(str, ans, ind + 1, n, k);

			ans.delete(ans.length() - 1, ans.length());
		}

	}

	

}
