package com.example.demo;

public class Star {
/*	
    *
   ***
  *****
 *******
**********/

	/*public static void main(String[] args) {
		int n=5;
		
		for(int i=5;i>=1;i--) {
			for(int j=1;j<i;j++) {
				System.out.print(" ");
			}
			
			for(int k=1;k<=(2*(n-i)+1);k++) {
				System.out.print("*");
			}
			 System.out.println();
		}
	}*/
	
	public static void main(String[] args) {
		int n=5;
		for(int i=5;i>=1;i--) {
			for(int j=1;j<i;j++) {
				System.out.print(" ");
			}
			
			for(int k=1;k<=2*(n-i)+1;k++) {
				if((n-i)== (n-1)) {
					System.out.print("*");
					continue;
				}
				if(k==1 || k== 2*(n-i)+1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
