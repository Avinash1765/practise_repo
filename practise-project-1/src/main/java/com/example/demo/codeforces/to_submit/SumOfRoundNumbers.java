
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfRoundNumbers {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		int roundarr[]= new int[50];
		
		for(int i=1;i<50;i++) {
			
			roundarr[i]= (int)((i%10)* Math.pow(10, (i/10)));
		}
		
		while(t-->0) {
			int cnt=0;
			List<Integer> answerArr= new ArrayList<>();
			
			int n= s.nextInt();
			
			while(n!=0) {
				
				for(int j=49; j>=0 && n!=0; j--) {
					if(j%10==0)
						continue;
					
					if(roundarr[j] <= n) {
						answerArr.add(roundarr[j]);
						cnt++;
						n-= roundarr[j];			
					}
				}
			}
			
			System.out.println(cnt);
			
			answerArr.stream().forEach(ele -> System.out.print(ele + " "));
			System.out.println();
		}
		
	}

}
