package leetCode30Day;

import java.util.Arrays;
import java.util.Stack;

public class D17_NumIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] arr = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };

		System.out.println(numIslands(arr));

	}

	public static int numIslands(char[][] grid) {
		int count = 0;

		int[][] temp = new int[grid.length][grid[0].length];

		for (int[] arr : temp)
			Arrays.fill(arr, -1);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (temp[i][j] != -1 || grid[i][j] == '0')
					continue;

				if (grid[i][j] == '1') {
					temp[i][j] = count;
					dfs(i, j, grid, temp, count);
					count++;
				}
			}
		}

		return count;

	}

	private static void dfs(int i, int j, char[][] grid, int[][] temp, int count) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<>();
		st.push(j);
		st.push(i);

		while (!st.isEmpty()) {
			int ii = st.pop();
			int jj = st.pop();
			// left block
			if (validNeighbours(ii, jj - 1, grid, temp, count, st)) {
				st.push(jj - 1);
				st.push(ii);
			}
			// right block
			if (validNeighbours(ii, jj + 1, grid, temp, count, st)) {
				st.push(jj + 1);
				st.push(ii);
			}
			// up block
			if (validNeighbours(ii - 1, jj, grid, temp, count, st)) {
				st.push(jj);
				st.push(ii - 1);
			}
			// down block
			if (validNeighbours(ii + 1, jj, grid, temp, count, st)) {
				st.push(jj);
				st.push(ii + 1);
			}
		}

	}

	private static boolean validNeighbours(int i, int j, char[][] grid, int[][] temp, int count, Stack<Integer> st) {
		// TODO Auto-generated method stub
		if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[i].length - 1) {

			if (temp[i][j] == -1 && grid[i][j] != '0') {
				temp[i][j]=count;
				return true;
			} else
				return false;

		} else
			return false;

	}

}
