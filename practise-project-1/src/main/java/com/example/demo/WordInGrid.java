package com.example.demo;

public class WordInGrid {
	static int targetStringPosition;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		WordInGrid obj=new WordInGrid();
		String arr[]= {"axmy", "bgdf", "xeet", "raks"};
		
		String toFind="rakz";
		
		obj.findIfPresent(arr,toFind);
		
		
	}

	private void findIfPresent(String[] arr, String toFind) {
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(arr[i].charAt(j) == toFind.charAt(targetStringPosition)) {
					//targetStringPosition++;
					matchNextChars(arr,i,j,toFind);
				}
			}
		}
		
		if(targetStringPosition< toFind.length())
			System.out.println("NO");
	}

	private void matchNextChars(String[] arr, int i, int j,String toFind) {
		if(i<0 || j<0 || i==4 || j==4)
			return;
		
		if(targetStringPosition==toFind.length()) {
			System.out.println("YES");
			System.exit(0);
		}
		
		if(arr[i].charAt(j) == toFind.charAt(targetStringPosition)) {
			targetStringPosition++;
			matchNextChars(arr, i+1, j, toFind);
			matchNextChars(arr, i, j+1, toFind);
			matchNextChars(arr, i-1, j, toFind);
			matchNextChars(arr, i, j-1, toFind);
			
		}
		
		
	}

}
