

import java.util.Scanner;

public class MinimalSquare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {

			int len = s.nextInt();
			int bre = s.nextInt();

			if (len < bre) {
				int temp = len;
				len = bre;
				bre = temp;
			}

			int ans = (int) Math.ceil(Math.sqrt(len * bre * 2));

			if (bre * 2 > ans) {
				ans = bre * 2;
			}

			System.out.println(ans * ans);

		}
	}

}
