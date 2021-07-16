package com.example.demo.codeforces;

/*package whatever //do not write package name here */
import java.util.Scanner;

class GFG {
	public static void main (String[] args) {
	       Scanner s= new Scanner(System.in);
	       String a= s.next();
	       String b= s.next();
	       
	       System.out.print(check(a,b));
	}
	
	public static int check(String a, String b){
	    return coreFn(a,b, 0,0, a.length(), b.length()) ? 1 : 0;
	}
	
	public static boolean coreFn(String a, String b, int ind1, int ind2, int len1, int len2){
	    if(ind2 >= len2)
	        return false;
	   if(ind1 >= len1)
	        return true;
	        
	    if(a.charAt(ind1) == b.charAt(ind2)){
	        return coreFn(a, b, ind1+1, ind2+1, len1, len2);
	    }
	    
	    if(a.charAt(ind1) != b.charAt(ind2)){
	        return coreFn(a,b, ind1, ind2+1, len1, len2);
	    }
	    
	    return false;
	}
}