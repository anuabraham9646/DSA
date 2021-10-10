package lc.Dynamic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatrixBlockSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[][] { { 76, 4, 73 }, { 21, 8, 56 }, { 4, 56, 61 }, { 70, 32, 38 }, { 31, 94, 67 } };

		int k = 1;
		int[][] res = helper(arr, k);

		for (int[] a : res) {
			for (int aa : a)
				System.out.print(" " + aa);
			System.out.println(" ");
		}
	}

	private static int[][] helper(int[][] mat, int k) {
		/*
		 * https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-
		 * integral-image/
		 * 
		 * summed area table
		 * 
		 */
		int[][] ans = new int[mat.length][mat[0].length];
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {

			for (int j = 0; j < mat[i].length; j++) {
				if (i == 0 && j == 0)
					ans[i][j] = mat[i][j];

				else if (i == 0) {
					ans[i][j] = mat[i][j] + ans[i][j - 1];

				} else if (j == 0)
					ans[i][j] = mat[i][j] + ans[i - 1][j];

				else {
					ans[i][j] = mat[i][j] + ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1];
				}

				// System.out.print(" "+ans[i][j]);
			}
			// System.out.println(" ");
		}
		int left = 0;
		int right = 0;
		int up = 0;
		int down = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				right = j + k >= mat[0].length ? mat[0].length - 1 : j + k;
				down = i + k >= mat.length ? mat.length - 1 : i + k;
				left = j - k <= 0 ? 0 : j - k;
				up = i - k <= 0 ? 0 : i - k;

				if (left == 0 && up == 0) {

					// System.out.println(i +" "+ j);
					mat[i][j] = ans[down][right];
					// System.out.println(mat[i][j]);
				} else {
					// int top= up-1>0 ? ans[right][up-1] : 0;
					int top = up - 1 < 0 ? 0 : ans[up - 1][right];
					// int lef= left-1>0 ? ans[left-1][down] : 0;
					int lef = left - 1 < 0 ? 0 : ans[down][left - 1];
					mat[i][j] = ans[down][right] - top - lef;
					if (top != 0 && lef != 0)
						mat[i][j] += ans[up - 1][left - 1];
				}

			}
		}

		return mat;
	}

}
