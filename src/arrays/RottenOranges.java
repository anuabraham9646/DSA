package arrays;

import java.util.HashSet;
import java.util.Set;

public class RottenOranges {
	// TODO Auto-generated method stub

	public static void main(String[] args) {

		int grid[][] = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println("Total minutes= " + rottenOranges(grid));

	}

	private static int rottenOranges(int[][] grid) {
		// TODO Auto-generated method stub
		int minutes = 0;

		Set<String> freshOrange = new HashSet<>();
		Set<String> rottenOrange = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
			}

		}
		return minutes;

	}
}
