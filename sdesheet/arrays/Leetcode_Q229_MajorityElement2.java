package arrays;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_Q229_MajorityElement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Integer> majorityElement(int[] nums) {
        int num1=-1,num2=-1,count1=0,count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1)
                count1++;
            else if(nums[i]==num2)
                count2++;
            else if(count1 ==0){
                num1=nums[i];
                count1++;
            }else if(count2==0){
                num2=nums[i];
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        int len= nums.length;
        List<Integer> lis= new ArrayList<>();
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1)
                count1++;
            else if(nums[i]==num2)
                count2++;
            
            
        }
        if(count1 >len/3)
                lis.add(num1);
        if(count2>len/3)
                lis.add(num2);
        return lis;
        
    }

}
