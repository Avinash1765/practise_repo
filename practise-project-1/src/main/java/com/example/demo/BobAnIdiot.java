package com.example.demo;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BobAnIdiot {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);	
		int numSwaps = s.nextInt();
		int arr[]=new int[52];
		Map<Character,Character> map=new HashMap<>();
		
		char key='A';
		while(key<='Z') {
			map.put(key, key);
			key++;
		}
		map.put(' ', ' ');
		
		while(numSwaps-->0) {
			char char1=s.next().charAt(0);
			char char2=s.next().charAt(0);
			
			char char1Value=map.get(Character.toUpperCase(char1));
			char char2Value=map.get(Character.toUpperCase(char2));
			map.put(Character.toUpperCase(char1), char2Value);
			map.put(Character.toUpperCase(char2), char1Value);
		}
		s.nextLine();
		String str=s.nextLine();
		
		System.out.println(findAnswer(str,map));
		
	}

	private static String findAnswer(String str,Map<Character,Character> map) {
		StringBuilder finalString=new StringBuilder();
		for(Character ch: str.toCharArray()) {
		    if(ch.isLowerCase(ch)){
		        char cht=map.get(Character.toUpperCase(ch));
		        finalString.append(Character.toLowerCase(cht));
		   } else
			    finalString.append(map.get(ch));
		}
		return finalString.toString();
	}

	/*private static void swap(int[] arr, int index1ToSwap, int index2ToSwap) {
		int t= arr[index1ToSwap];
		arr[index1ToSwap]= arr[index2ToSwap];
		arr[index2ToSwap]=t;
	}*/

}
