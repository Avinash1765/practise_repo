

import java.util.Arrays;
import java.util.Scanner;

public class NewYearNumberFinal {

	int[] dp;
	
	public NewYearNumberFinal() {
		dp=new int[1000001];
		Arrays.fill(dp, -1);
	}
	
	public static void main(String[] args) {
		
		NewYearNumberFinal obj= new NewYearNumberFinal();
		
		obj.prefill();
		
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int ele= s.nextInt();
			if(ele==0) {
				System.out.println("NO");
				continue;
			}
			System.out.println(obj.dp[ele]!=-1 ? "YES" : "NO");
		}
	}

	private void prefill() {
			
		dp[2020]=1;
		dp[2021]=1;
		
		preFillRecurUtil(4040);
		preFillRecurUtil(4041);
		preFillRecurUtil(4042);
		
	}

	private void preFillRecurUtil(int ind) {
		if(ind > 1000000)
			return;
		if(dp[ind]!=-1)
			return;
		dp[ind]=1;
		
		preFillRecurUtil(ind+2020);
		preFillRecurUtil(ind+2021);
	}

	public boolean findAns(int n) {
		
		if(n<0)
			return false;
		if(n==0)
			return true;
		if(dp[n]!=-1)
			return true;
		if(findAns(n-2020) || findAns(n-2021)) {
			dp[n]=1;
			return true;
		}
		return false;
	}
}
