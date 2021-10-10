package arrays;

import java.util.*;

public class Leetcode_Q18_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        return kSum(nums,target,0,4);
        
    }
	private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
		// TODO Auto-generated method stub
		List<List<Integer>> ans= new  ArrayList<>();
        
		if(k==2) {
			int lo= start;
			int hi= nums.length-1;
			while(lo < hi) {
				int sum= nums[lo]+nums[hi];
				if(sum == target) {
					List<Integer> tmp=	new  ArrayList<>();
					tmp.add(nums[lo]);
					tmp.add(nums[hi]);
					ans.add(tmp);
					while(lo < hi && nums[lo]==nums[lo+1])lo++;
					while( hi > lo && nums[hi-1]==nums[hi])hi--; // since our hi is at the same value we need to decrement hi again and inc lo
					lo++;
					hi--;
				}
				else if(sum < target) lo++;
				else hi--;
			}
            return ans;
		}else {
			for(int i=start ;i< nums.length-k +1; i++) {
				List<List<Integer>> temp = kSum(nums,target-nums[i],i+1,k-1);
				if (temp.size() !=0) {
					for (List<Integer> t : temp)
						t.add(0, nums[i]);
					ans.addAll(temp);
					
				}
                while (i < nums.length - 1 && nums[i] == nums[i + 1])
						i++;
			}
		}
		return ans;
	}
}
