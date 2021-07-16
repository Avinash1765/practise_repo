package com.example.demo.codeforces;

import java.util.Scanner;

public class NumberOfWays {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		
		long arr[]= new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = s.nextLong();
		}
		
		System.out.println(findWays(arr, n));
	}

	private static int findWays(long[] arr, int n) {
		long sumArr[]= new long[n];
		
		sumArr[0]= arr[0];
		for(int i=1;i<n;i++) {
			sumArr[i] = arr[i]+ sumArr[i-1];
		}
		
		if(sumArr[n-1]%3 !=0)
			return 0;
		
		long unitSum= sumArr[n-1]/3;
		
		int unitSumFirstInd= first(sumArr, 0, n-2, unitSum, n);
		
		if(unitSumFirstInd==-1)
			return -1;
		int unitSumLastInd= last(sumArr, 0, n-2, unitSum, n);
		
		int numOccurencesUnitSum= (unitSumLastInd - unitSumFirstInd +1);
		
		int secondUnitSumFirstInd= first(sumArr, 0, n-2, unitSum*2, n);
		
		if(secondUnitSumFirstInd==-1)
			return -1;
		int secondUnitSumLastInd= last(sumArr, 0, n-2, unitSum*2, n);
		
		int numOccurencesSecondUnitSum= (secondUnitSumLastInd - secondUnitSumFirstInd +1);
		
		
		return (numOccurencesUnitSum * numOccurencesSecondUnitSum );
	}
	
	public static int first(long arr[], int low, int high, long x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
                return mid;
            else if (x > arr[mid])
                return first(arr, (mid + 1), high, x, n);
            else
                return first(arr, low, (mid - 1), x, n);
        }
        return -1;
    }
 
    /* if x is present in arr[] then returns the index of
    LAST occurrence of x in arr[0..n-1], otherwise
    returns -1 */
    public static int last(long arr[], int low, int high, long x, int n)
    {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == n - 1 || x < arr[mid + 1]) && arr[mid] == x)
                return mid;
            else if (x < arr[mid])
                return last(arr, low, (mid - 1), x, n);
            else
                return last(arr, (mid + 1), high, x, n);
        }
        return -1;
    }

}
