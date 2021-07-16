import java.util.Scanner;

public class NextRound {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int k=s.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++)
			arr[i]= s.nextInt();
		k= arr[k-1];
		
		if(k==0)
			k++;
		
		System.out.println(binarySearch(n,k, arr)+1);

	}

	private static int binarySearch(int n, int k, int[] arr) {
		int l=0, r=n-1, ans=-1;
		if(arr[0]< k)
			return -1;
		if(arr[n-1]>=k)
			return n-1;
		
		while(l<=r) {
			int mid = l + ((r-l)/2);
			
			if(arr[mid] >= k) {
				l= mid+1;
				ans=mid;				
			}
			else
				r= mid-1;		 				
		}		
		return ans;	
	}

}
