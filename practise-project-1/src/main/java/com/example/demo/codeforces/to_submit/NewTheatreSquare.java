

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewTheatreSquare {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			int n= s.nextInt();
			int m=s.nextInt();
			int x= s.nextInt();
			int y=s.nextInt();
			
			List<String> stringList= new ArrayList<>();
			
			for(int i=0;i<n;i++) {
				stringList.add(s.next());
			}
			
			List<List<Integer>> valList= new ArrayList<>();
			
			for(String str: stringList) {
				int cnt= 0;
				List<Integer> valListItem= new ArrayList<>();
				
				for(char c : str.toCharArray()) {
					if(c == '.')
						cnt++;
					else {
						if(cnt>0)
							valListItem.add(cnt);
						cnt=0;
					}
				}
				if(cnt>0)
					valListItem.add(cnt);
				valList.add(valListItem);
			}
			
			boolean greedFlag= (x <= (y/2));
			
			int ans= 0;
			
			for(List<Integer> valListItem : valList) {
				for(Integer val: valListItem) {
					if(greedFlag)
						ans += (val * x);
					else {
						ans += ( (val/2) * y + ((val%2) * x));
					}
				}
			}
			
			System.out.println(ans);
		}
		
		s.close();
	}

}
