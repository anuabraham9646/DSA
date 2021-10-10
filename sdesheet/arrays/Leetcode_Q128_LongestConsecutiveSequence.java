package arrays;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_Q128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums= new int[] {0,3,7,2,5,8,4,6,0,1};
		System.out.println(longestConsecutive(nums));

	}
	public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;
// the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can only run for nn iterations throughout the entire runtime of the algorithm. 
                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
