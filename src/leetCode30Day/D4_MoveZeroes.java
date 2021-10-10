package leetCode30Day;

import java.util.Arrays;

public class D4_MoveZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= new int[] {1,0};
		//System.out.println(moveZeroes(nums));
		Arrays.stream(moveZeroes(nums)).forEach(System.out::print);

	}

	private static int[] moveZeroes(int[] nums) {
		// TODO Auto-generated method stub
		int zero=0,nonZe=0;
		while(zero<nums.length && nonZe < nums.length ) {
			if(nums[zero]!=0)
				zero++;
			if(nums[nonZe]==0)
				nonZe++;
			if(zero > nonZe)
				nonZe++;
			
			if((zero<nums.length && nonZe < nums.length)&&(nums[zero]==0 && nums[nonZe]!=0)) {
				swap(nums,zero,nonZe);
				zero++;
				nonZe++;
			}
			
			
		}
		
		return nums;
	}

	private static void swap(int[] nums, int zero, int nonZe) {
		// TODO Auto-generated method stub
		int temp =nums[zero];
		nums[zero]=nums[nonZe];
		nums[nonZe]=temp;
		
	}

}
