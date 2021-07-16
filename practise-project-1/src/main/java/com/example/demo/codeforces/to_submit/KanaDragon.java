import java.util.Scanner;

public class KanaDragonGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		
		while(t-->0) {
			long x = s.nextLong();
			long n = s.nextLong();
			long m = s.nextLong();
			
			System.out.println(check(x,n,m) ? "YES" : "NO");
		}
	}

	private static boolean check(long x, long n, long m) {
		
		while(x>0) {
			if(x>20 && n>0) {
				x= (long)Math.floor(x/2) +10l;
				n--;
			}else if(m>0){
				x-=10;
				m--;
			}else {
				break;
			}
		}
		
		if(x<=0)
			return true;
		else
			return false;
	}

}
