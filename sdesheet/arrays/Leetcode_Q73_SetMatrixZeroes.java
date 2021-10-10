package arrays;

public class Leetcode_Q73_SetMatrixZeroes {
//https://leetcode.com/problems/set-matrix-zeroes/submissions/
	//try to do in O(1) space
	/*
	 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

					Follow up:

			A straight forward solution using O(mn) space is probably a bad idea.
			A simple improvement uses O(m + n) space, but still not the best solution.
			Could you devise a constant space solution?
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int matrix[][] = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		int matrix[][] = new int[][] { { 1,1,1 }, { 1,0,1 }, { 1,1,1 } };
		setZeroes(matrix);

	}

	public static void setZeroes(int[][] matrix) {
		/*
		 * So the Solution is that instead of creating a new matrix we use the current matrix 
		 * row 0 & col 0 to store is any of the value in that row or col was 0
		 * eg   if m[i][j] ==0  then we set m[i][0] & m[0][j] as zero because in the end this will would automatically be 0
		 * so we can make use of that matrix itself to store the details
		 * Things to note
		 * we use 2 variable to keep track of 0th row and 0th column  
		 */
		boolean firstRowZero = false;
		boolean firstColZero = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0)
						firstRowZero = true;
					if (j == 0)
						firstColZero = true;
					if (i != 0 && j != 0) {
						matrix[0][j] = 0;
						matrix[i][0] = 0;
					}
				}
			}
		}

		
		/*
		 * here we start from 1,1 because of the 0th row is 0 then the entire row is 0 and wil make the entire matrix 0
		 * so we start from 1,1 check if the [0][j] & [i][0] were 0 if yes then we set [i][j] as 0
		 */
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {

					matrix[i][j] = 0;
				}
			}
		}

		int numCols = matrix[0].length;
		if (firstRowZero) {
			for (int i = 0; i < numCols; i++)
				matrix[0][i] = 0;
		}
		if (firstColZero) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}
		/*
		 * in the end above 2 loops we set the 0st col and 0 row as zero to not overwrite our placeholders which keep track of al the other elts 
		 */
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println(" ");
		}

	}

}
