

import java.util.Scanner;

public class MakeProductEqualOne {

	public static void main(String[] args) {
		Scanner  s=new Scanner(System.in);
		
		int nCnt=0;
		int ans=0;
		int zeroCnt=0;
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
			if(arr[i]<0) 
				nCnt++;
			if(arr[i]==0)
				zeroCnt++;
			ans += Math.abs((Math.abs(arr[i]) - 1));
		}
		
		if((nCnt&1)==1 && zeroCnt==0)
			ans+=2;
		System.out.println(ans);
			
	}

}
