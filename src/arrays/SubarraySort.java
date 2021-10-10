package arrays;

public class SubarraySort {

	public static void main(String[] args) {

		int arr[] = new int[] { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(findUnsortedSubarray(arr));

	}

	public static int findUnsortedSubarray(int[] nums) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				flag = true;
				min = Math.min(min, nums[i]);
				max = Math.max(max, nums[i - 1]);
			}
		}

		System.out.println(min);
		System.out.println(max);

		int count1 = 0, count2 = 0;

		if (!flag)
			return 0;
		else {
			for (int i = 0; i < nums.length; i++) {
				if (min < nums[i]) {
					count1 = i;
					break;
				}
			}

			for (int i = nums.length - 1; i >= 0; i--) {
				if (max > nums[i]) {
					count2 = i;
					break;
				}
			}

			return count2 - count1 + 1;
		}

	}

}
