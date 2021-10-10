package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//!Q	https://leetcode.com/problems/combination-sum-ii/
public class Leetcode_Q40_CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int candidates[] = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> ans = combinationSum2(candidates, target);

		for (List<Integer> l : ans) {
			for (int i : l) {
				System.out.print(" " + i);
			}
			System.out.println("");

		}

	}

	public static List<List<Integer>> combinationSum2(int[] c, int t) {
		Arrays.sort(c);
		List<List<Integer>> ans = new ArrayList<>();
		findCombination(0, c, t, ans, new ArrayList<>());
		return ans;

	}

	public static void findCombination(int start, int[] cand, int target, List<List<Integer>> ans, List<Integer> temp) {

		if (start == cand.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(temp));

			}

			return;
		}
		if (target == 0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		if (cand[start] <= target) {
			temp.add(cand[start]);
			findCombination(start + 1, cand, target - cand[start], ans, temp);
			int val = temp.remove(temp.size() - 1);
			start++;
			/*
			 * since this is sorted in line 52 after backtracking to avoid duplicate entry
			 * we use while loop to not use the last removed value
			 * eg 1 1 1 3
			 * suppose if we remove th 1 at 1st location and we add the 1 at 2nd location it vl be duplicate hence we loop till we reach 3
			 */
			while (start < cand.length && cand[start] == val)
				start++;
			findCombination(start, cand, target, ans, temp);

		} else
			return;
	}

}
