package leetCode30Day;

import java.util.Arrays;
import java.util.HashMap;

public class D13_ContiguousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		findMaxLength(new int[] { 0, 1, 0, 0, 1 });

	}

	public static int findMaxLength(int[] nums) {
		int maxLen = 0;
		int sum = 0;
		nums = Arrays.stream(nums).map(a -> {
			if (a == 0)
				return -1;
			else
				return 1;
		}).toArray();

		/*for (int i : nums)
			System.out.println(i);*/
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == 0) {
				maxLen = Math.max(maxLen, i + 1);
				map.put(sum,i);
			}else {
				if(map.containsKey(sum)) {
					maxLen= Math.max(maxLen, i -map.get(sum));
				}
				else
					map.put(sum,i);
			}
		}
		
		System.out.println(maxLen);

		return maxLen;
	}

}
