package arrays;

public class Leetcode_Q1053_PreviousPermutationWithOneSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = new int[] {1,9,4,6,7};
		solve(arr);

	}

	private static void solve(int[] nums) {
        /*
        From last we traverse to left to find the dip is the dip has 1,1 then we take the farthest 
        equal value to the left.
        */
        int dipPos=nums.length-1;
		for(int j=nums.length-2; j>=0 && nums[j]<=nums[j+1];j--)
			dipPos=j;
		if(dipPos==0) {
			
			return;
		}
		
		int leftToDipVal=nums[dipPos-1];
		int leftToDipPos=dipPos-1;
		/*
		 * currently we are 1 elt before the dip to make it next permutation we must find greatest number in the right side which is less than the leftToDipVal then swap
		 
		 */
		
		int nextGreatPos=nums.length-1;
        int nextGreatPosVal=Integer.MIN_VALUE;
		for(int j=nums.length-1; j>=dipPos;j--) {
			if(nums[j] < leftToDipVal && nums[j] >=nextGreatPosVal) {
				nextGreatPos=j;
				nextGreatPosVal=nums[j];
			}
		}
		
		nums[leftToDipPos]=nums[nextGreatPos];
		nums[nextGreatPos]=leftToDipVal;
		return;	
	}

}
