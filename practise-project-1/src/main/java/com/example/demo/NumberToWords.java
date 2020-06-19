package com.example.demo;

import java.util.Scanner;

public class NumberToWords {

	public static void main(String[] args) {
		String arr[]= {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		NumberToWords obj=new NumberToWords();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		while(n>0) {
		int num= s.nextInt();		
		System.out.println(obj.getInWords(num,arr));
		n--;
		}
	}

	private String getInWords(int num, String arr[]) {
		
		String finalString="";
		
		String eensArr[]= {"ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String tyArr[]= {"ten","twenty", "thirty", "forty", "fifty", 
                "sixty", "seventy", "eighty", "ninety"};
		while(num!=0) {
			String str=String.valueOf(num);
			if(str.length()==4) {
				finalString=finalString.concat(arr[Integer.parseInt(str.substring(0, 1))-1]+" thousand ");
				num= Integer.parseInt(str.substring(1));
			}
			/*else if(str.length()==3 && str.charAt(0)=='0') {
				num= Integer.parseInt(str.substring(1));
			}*/else if(str.length()==3) {
				finalString=finalString.concat(arr[Integer.parseInt(str.substring(0, 1))-1]+" hundred and ");
				num= Integer.parseInt(str.substring(1));
			}else if(str.length()==2 && Integer.parseInt(str)>=11 && Integer.parseInt(str)<=19) {
				finalString=finalString.concat(eensArr[Integer.parseInt(str.substring(1, 2))]+" ");
				break;
			}else if(str.length()==2 && Integer.parseInt(str)%10==0) {
				finalString=finalString.concat(tyArr[Integer.parseInt(str.substring(0,1))-1]+ " ");
				break;
			}else if(str.length()==2) {
				finalString=finalString.concat(tyArr[Integer.parseInt(str.substring(0,1))-1] + " ");
				num= Integer.parseInt(str.substring(1));
			}else {
				finalString=finalString.concat(arr[Integer.parseInt(str.substring(0))-1]);
				break;
			}
			
		}
		
		if(finalString.endsWith("and "))
			finalString=finalString.replaceAll("and ", "");
		
		return finalString;
	}

}
