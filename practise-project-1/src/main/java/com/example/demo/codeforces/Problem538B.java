package com.example.demo.codeforces;

public class Problem538B {
	
	
	
	private static final int MAX_QBNUM = 111111;

	public static void main(String[] args) {
		
	}
	
	private int[] generateQuasiBinaryNums() {
		int quasiBinNums[] = new int[500];
		int cnt=0;
		int ind=1;
		
		quasiBinNums[0]=1;
		String currentQBNum= "1";
		
		while(true) {
			
			int decimalQB= Integer.parseInt(currentQBNum);
			
			if(currentQBNum==MAX_QBNUM)
				break;
		}
		
	}

}
