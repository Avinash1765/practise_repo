

import java.util.Scanner;

public class ArrivaloftheGeneral {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		
		int minIndex = -1, maxIndex=-1, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, ans=0;
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
			
			if(arr[i] <= min) {
				minIndex = i;
				min = arr[i];
			}
			
			if(arr[i] > max) {
				maxIndex = i;
				max= arr[i];
			}
		}
		
		ans = (maxIndex + (n-1-minIndex));
		
		if(maxIndex > minIndex)
			ans--;
		
		System.out.println(ans);
		
		
		
	}

}
