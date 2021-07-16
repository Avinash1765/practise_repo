

import java.util.Scanner;

public class LeftRotation {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int d = s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = s.nextInt();
		
		int k= d%n;
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[(i+k)%n] + " ");
		}
	}

}
