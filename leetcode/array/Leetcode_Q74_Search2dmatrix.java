package array;

public class Leetcode_Q74_Search2dmatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		int row = matrix.length;
		row--;
		int col = matrix[0].length;
		col--;

		if (target < matrix[0][0] || target > matrix[row][col])
			return false;
		int top = 0;
		int low = row;
		if (row == 0)
			return searchRow(0, matrix, target, col);
		while (top < low) {
			int mid = top + (low - top) / 2;

			if (target == matrix[mid][col])
				return true;
			else if (target > matrix[mid][col])
				top = mid + 1;
			else
				low = mid;
		}

		return searchRow(low, matrix, target, col);

	}

	private static boolean searchRow(int low, int[][] matrix, int target, int col) {
		// TODO Auto-generated method stub
		int left = 0;
		int right = col;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == matrix[low][mid])
				return true;
			else if (target > matrix[low][mid])
				left = mid + 1;
			else
				right = mid - 1;

		}
		return false;
	}

}
