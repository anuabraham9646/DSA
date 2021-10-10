package leetCode30Day;

import java.util.HashMap;

public class D25_JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = new int[] { 2,3,1,1,4 };
		System.out.println(canJump(nums));
		
	}

	private static boolean canJump(int[] nums) {
		
		
		/*if(nums.length == 1)
            return true;
        
        int maxReachable=0;
        //maxReachable is the maximum location that can be reached
        for(int i=0;i < nums.length;i++){
            // if we have reached a position greater than maxReachabe them we have  moved beyind reachable
            if(i > maxReachable)
                return false;
            // max Reachable is max of already calculated or adding nums[i] plus the current position
            maxReachable= Math.max(maxReachable, nums[i]+i);
            
            // if in between we reached before calculating then true
            if(maxReachable >= nums.length-1)
                return true;
        }
        
        return maxReachable >=nums.length-1;*/
		
		
		
		
		HashMap<Integer,Boolean> hm= new HashMap<>();
		Boolean temp= helperRec(nums,0,hm);
		System.out.println(hm);
		return temp;
	}

	private static boolean helperRec(int[] nums, int i, HashMap<Integer, Boolean> hm) {
		// TODO Auto-generated method stub
		if(i>=nums.length-1)
			return true;
		
		
		if(hm.containsKey(i))
			return hm.get(i);
		
		else {
			boolean val= false;
			int maxDist=Math.min(i+nums[i], nums.length-1);
			for(int j=i+1; j <=maxDist;j++) {
				
				val = val||helperRec(nums,j,hm);
				hm.put(i, val);
				//return hm.get(j);
			}
			
			return false;
		}
		
		
	}

}
