package array;

public class Leetcode_Q287_FindTheDuplicateNumber {
//https://leetcode.com/problems/find-the-duplicate-number/
	public static void main(String[] args) {

		int nums[] = new int[] { 1, 3, 4, 2, 2 };
		System.out.println(sol1binarySearch(nums));
	}

	private static int sol1binarySearch(int[] nums) {
        
        int l=1,hi=nums.length-1;
        /*
         * applying the bin search on indexes since the numbers are from 1 to n and so are the index so considering bin search
         * if the mid lets say 1 ----> 10  mid= 5 
         * now we count all the number  in the array <= 5 if the count >=5 eg7  then we can be sure between 1->5 there are 7 counts
         * hence the duplicate is in the boundary 1->5
         * else if the count is 2  then between 6 to 10 there is count of 8 hence the duplicate is in the other subarray;
         */
        while(l < hi){
            int mid= l+(hi-l)/2;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] <=mid)
                    count++;  
            }
            
            if(count <=mid)
                l=mid+1;
            else
                hi=mid;
        }
        return l;
    }

}
