package com.example.demo.leetcode;

public class Problem374 {

	public static void main(String[] args) {
		System.out.println(new Problem374().guessNumber(2126753390));

	}
	
	public int guessNumber(int n) {
		 long l=1;
	        long r=n;
	        
	        int flag=-1;
	        
	        while(true){
	        	long val= (l+r);
	            int mid= (int)(val/2);
	            
	            flag=guess(mid);
	            
	            if(flag==0)
	                return mid;
	            else if(flag==1)
	                l=mid+1;
	            else
	                r= mid-1;
	        }
    }
	
	public int guess(int n) {
		return -1 * (int)Math.signum(n-1702766719);
	}

}
