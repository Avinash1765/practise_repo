

import java.util.Scanner;

public class AccurateLee {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		while (t-- > 0) {
			int n = s.nextInt();

			StringBuilder str = new StringBuilder(s.next());

			int lZFlag = -1;

			char[] zeroArr = new char[1];
			zeroArr[0] = '0';

			for (int i = n - 1; i >= 0; i--) {
				if (str.charAt(i) == '0') {
					if (lZFlag == -1) {
						lZFlag = i;
					}
				} else {
					if (lZFlag != -1) {
						str.replace(i, lZFlag + 1, new String(zeroArr));
						lZFlag = i;
					}
				}
			}

			System.out.println(str);

		}
	}

}
