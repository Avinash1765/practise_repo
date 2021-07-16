package com.example.demo.leetcode;

public class Problem953 {

	public static void main(String[] args) {
		String[] words= {"hello","leetcode"};
		String order="hlabcdefgijkmnopqrstuvwxyz";
		
		System.out.println(isAlienSorted(words,order));
	}

	public static boolean check(String a, String b, String order) {

		int l = a.length();
		int r = b.length();

		for (int i = 0; i < l && i < r; i++) {
			int fi = order.indexOf(a.charAt(i));
			int si = order.indexOf(b.charAt(i));

			if (fi > si)
				return false;
		}

		return true;

	}

	public static boolean isAlienSorted(String[] words, String order) {
		int numWords = words.length;

		for (int i = 0; i < numWords - 1; i++) {
			String a = words[i];
			String b = words[i + 1];

			boolean lexFLag = check(a, b, order);
			if (!lexFLag)
				return false;
		}

		return true;
	}

}
