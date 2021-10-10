package leetCode30Day;

import java.util.HashMap;

public class D22_SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fun(new int[] { 1,1,2,3,-2,-1}, 2));

	}

	private static int fun(int[] nums, int k) {
		int count=0;
        int sum=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int n : nums){
            sum+=n;
            if(sum == k)
                count++;
            if(hm.containsKey(sum-k)){
                count+= hm.get(sum-k);
            }
            
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
	}

}
