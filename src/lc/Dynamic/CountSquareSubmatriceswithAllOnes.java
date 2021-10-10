package lc.Dynamic;

public class CountSquareSubmatriceswithAllOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[][] = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		System.out.println(helper(arr));

	}

	private static int helper(int[][] mx) {
		int r = mx.length;
		if (r <= 0)
			return 0;
		int c = mx[0].length;

		int dp[][] = new int[r][c];
		int count = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				if (i == 0 || j == 0 || mx[i][j] == 0) {
					if (mx[i][j] == 0)
						dp[i][j] = 0;
					else {
						dp[i][j] = 1;
						count++;
					}

				} else {
					// count++;
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);

					count += dp[i][j];

				}
				// max=Math.max(max,dp[i][j]);
			}
		}
		
		for(int i=0;i< r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(" "+dp[i][j]);
			}
			System.out.println(" ");
		}

		return count;

	}

}
