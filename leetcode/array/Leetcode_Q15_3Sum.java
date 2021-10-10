package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Q15_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public List<List<Integer>> threeSum(int[] nums) {
        
        int target=0;
        List<List<Integer>> lis= new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (nums[i]!=nums[i-1])){
                target=0-nums[i]; // since a+b+c=0  =>  a+b= -c
                int left =i+1,right= nums.length-1;
    //Since its sorted if the 1st nums is >0 then obviouslt all other >0 so sum of 0 not possible
                if(nums[i]>0) 
                    break;
                while(left<right){
                    int sum = nums[left]+nums[right];
                    if(sum==target){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        lis.add(temp);
                        while(left < right && nums[left+1] == nums[left])
                            left++;
                        while(left < right && nums[right-1] == nums[right])
                            right--;
                        left++;
                        right--;
                    }
                    else if(sum >target)
                        right--;
                    else 
                        left++;
                }
            }
        }
        
       return lis; 
        
        
    }

}
