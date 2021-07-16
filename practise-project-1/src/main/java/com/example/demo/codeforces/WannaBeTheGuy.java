package com.example.demo.codeforces;

import java.util.Scanner;

public class WannaBeTheGuy {
	public static void main(String[] A) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(), a = 0, x, r[] = new int[n];
		for (; a++ < 2;)
			for (x = s.nextInt(); x-- > 0;)
				if (r[s.nextInt() - 1]++ < 1)
					n--;
		System.out.print(n > 0 ? "Oh, my keyboard!" : "I become the guy.");
	}
}

