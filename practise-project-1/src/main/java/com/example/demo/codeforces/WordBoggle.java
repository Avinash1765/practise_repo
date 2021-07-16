package com.example.demo.codeforces;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordBoggle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t-- > 0) {
			int x = s.nextInt();

			TrieNode root = new TrieNode();

			Set<String> discoveredWords = new TreeSet<>();
			int maxStrLen = -1;
			
			for (int i = 0; i < x; i++) {
				String str = s.next().toUpperCase();
				maxStrLen = Math.max(maxStrLen, str.length());
				
				root.buildTrie(str);
			}

			int n = s.nextInt();
			int m = s.nextInt();

			char grid[][] = new char[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					grid[i][j] = s.next().toUpperCase().charAt(0);
				}
			}

			boolean visited[][] = new boolean[n][m];
			StringBuilder currentWord = new StringBuilder();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					checker(grid, n, m, i, j, discoveredWords, visited, currentWord, root, maxStrLen, 0);
				}
			}

			if (discoveredWords.size() == 0)
				System.out.println(-1);
			else {
				for (String st : discoveredWords) {
					System.out.print(st + " ");
				}
				System.out.println();
			}
		}
	}

	private static void checker(char[][] grid, int n, int m, int l, int r, Set<String> discoveredWords,
			boolean[][] visited, StringBuilder currentWord, TrieNode root, int maxStrLen, int currStrLen) {

		if (!(l >= 0 && r >= 0 && l < n && r < m && !visited[l][r]))
			return;
		
		int currentIndex = (grid[l][r] >= 65 && grid[l][r] <= 90 ? grid[l][r] - 65 : grid[l][r] - 97 + 26);
		
		if (root.charRefArr[currentIndex] == null)
			return;
		
		if(currStrLen > maxStrLen)
			return;

		visited[l][r] = true;
		currentWord.append(grid[l][r]);
		++currStrLen;

		if (root.charRefArr[currentIndex].isWordEnd) {
			discoveredWords.add(currentWord.toString());
		}

		checker(grid, n, m, l - 1, r - 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l - 1, r, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l - 1, r + 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l, r - 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l, r + 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l + 1, r - 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l + 1, r, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);
		checker(grid, n, m, l + 1, r + 1, discoveredWords, visited, currentWord, root.charRefArr[currentIndex], maxStrLen, currStrLen);

		visited[l][r] = false;
		currentWord.delete(currentWord.length() - 1, currentWord.length());
		--currStrLen;
	}

	static class TrieNode {

		public TrieNode[] charRefArr = new TrieNode[52];
		public boolean isWordEnd = false;

		public void buildTrie(String str) {

			TrieNode currentNode = this;

			for (char ch : str.toCharArray()) {
				if (currentNode.charRefArr[(ch >= 65 && ch <= 90 ? ch - 65 : ch - 97 + 26)] == null) {
					TrieNode newNode = new TrieNode();
					currentNode.charRefArr[(ch >= 65 && ch <= 90 ? ch - 65 : ch - 97 + 26)] = newNode;
					currentNode = newNode;
				} else {
					currentNode = currentNode.charRefArr[(ch >= 65 && ch <= 90 ? ch - 65 : ch - 97 + 26)];
				}
			}

			currentNode.isWordEnd = true;
		}

	}

}
