import java.util.Scanner;

public class Polygon {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		while (t-- > 0) {
			boolean ans= false;
			int n = s.nextInt();
			int arr[][] = new int[n][n];
			boolean visited[][] = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String str = s.next();

				for (int j = 0; j < n; j++) {
					arr[i][j] = (int) (str.charAt(j) - '0');
				}
			}

			for (int i = 0; i < n; i++)
				dfs(arr, n, visited, n - 1, i);

			for (int i = 0; i < n; i++)
				dfs(arr, n, visited, i, n - 1);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1 && !visited[i][j]) {
						ans= true;
						break;
					}
				}
				if(ans)
					break;
			}
			
			
			System.out.println(!ans ? "YES" : "NO");
		}

	}

	private static void dfs(int[][] arr, int n, boolean[][] visited, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n || arr[i][j] == 0 || visited[i][j])
			return;

		visited[i][j] = true;

		dfs(arr, n, visited, i, j - 1);
		dfs(arr, n, visited, i - 1, j);

	}

}
