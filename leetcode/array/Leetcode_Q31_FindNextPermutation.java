package array;

import java.util.Arrays;

public class Leetcode_Q31_FindNextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {3,1,2,4};
		nextPermutation(arr);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}

	private static void nextPermutation(int[] nums) {
		// TODO Auto-generated method stub
		if(nums.length<2)
			return;
		/*
		 * here the idea is to visualize the peaks
		 * ideally to find increase number by smallest margin we should find the rightmost place hence we find the rightmost peak
		 * as step1 and try to move it 1 step left we have atleast 1 elt in peak
		 */
		int peakPos=nums.length-1;
		for(int j=nums.length-2; j>=0 && nums[j]>=nums[j+1];j--)
			peakPos=j;
		if(peakPos==0) {
			int i=0;
			int j= nums.length-1;
			while(i<j) {
				int temp= nums[i];
				nums[i]= nums[j];
				nums[j]=temp;
				i++;
				j--;
			}
			return;
		}
		
		int leftToPeakVal=nums[peakPos-1];
		int leftToPeakPos=peakPos-1;
		/*
		 * currently we are 1 elt before the peak to make it next permutation we must find greater number in the right side
		 * such that it is the smallest num greater than it  eg 2	4	5	3	6
		 * suppose elt is 2  we can swap with 4 but we want the smallest possible increase so we must swap 2 with 3
		 */
		
		int nextGreatPos=nums.length-1;;
		for(int j=nums.length-1; j>=0;j--) {
			if(nums[j] > leftToPeakVal) {
				nextGreatPos=j;
				break;
			}
		}
		
		nums[leftToPeakPos]=nums[nextGreatPos];
		nums[nextGreatPos]=leftToPeakVal;
		int i=peakPos;
		int j=nums.length-1;
		while(i<j) {
			int temp= nums[i];
			nums[i]= nums[j];
			nums[j]=temp;
			i++;
			j--;
		}
		
	}

}
