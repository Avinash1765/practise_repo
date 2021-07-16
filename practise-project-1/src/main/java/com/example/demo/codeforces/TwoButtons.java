package com.example.demo.codeforces;

import java.util.Scanner;

public class TwoButtons {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		System.out.println(findNumClicks(n, m));
	}

	private static int findNumClicks(int n, int m) {
		if (n == m)
			return 0;
		if (n > m)
			return n - m;

		int tempVal = divisibleInPoW2(n, m);
		if (tempVal > 0)
			return tempVal;
		else {
			int a = 1 + findNumClicks(n - 1, m);
			int b = 1 + findNumClicks(2 * n, m);

			return Math.min(a, b);
		}
	}

	private static int divisibleInPoW2(int n, int m) {

		int powVal = 1;
		while (powVal < 20) {
			if ((int) (Math.pow(2, powVal)) * n <= m) {
				powVal++;
			}else {
				return powVal-1;
			}
			
		}
		return -1;
	}

}
