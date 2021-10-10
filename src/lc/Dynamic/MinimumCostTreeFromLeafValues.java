package lc.Dynamic;

import java.util.LinkedList;
import java.util.List;

public class MinimumCostTreeFromLeafValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= new int[] {6,2,4};
		
		System.out.println(soln(arr));
		
		System.out.println(solnArrayList(arr));

	}

	private static int solnArrayList(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> vals= new LinkedList<>();
		for(int n: arr)
			vals.add(n);
		//we add everything in linkedlist
		int res=0;
		while(vals.size()>1) {
			int min= Integer.MAX_VALUE;
			int minIdx=0;
			for(int i=0;i< vals.size();i++) {
				if(vals.get(i) < min) {
					minIdx= i;
					min= vals.get(i);
				}
			}
			int partner;
			if(minIdx==0)
				partner= vals.get(minIdx+1);
			else if(minIdx== vals.size()-1)
				partner= vals.get(minIdx-1);
			else
				partner= Math.min(vals.get(minIdx-1), vals.get(minIdx+1));
			
			res+=min*partner;
			vals.remove(minIdx);
		}
		
		return res;
	}

	private static int soln(int[] arr) {
		int dp[][]= new int[arr.length+1][arr.length+1];
        return helper(0,arr.length-1,dp,arr);
	}
	public static int helper(int start,int end,int [][] dp,int[] arr){
		//System.out.println(start +" "+ end);
		if(start>= end )
            return 0;
	//base case that there should be atleast 2 elements to find the root
		
        if( dp[start][end]>0)
            return dp[start][end];
        
        int ans= Integer.MAX_VALUE;
        for(int i= start;i<end;i++){
            int rootVal= getMax(start,i,arr)*getMax(i+1,end,arr);
            /*
             * inorder is left child root right child
             * by question root is calculated by max of left subtree and right subtree hence we find the 
             * max from the left and max from right
             */
            ans= Math.min(ans,rootVal+helper(start,i,dp,arr)+helper(i+1,end,dp,arr));
            /*
             * ans should be minimum of all the non leaf value
             */
            
        }
        dp[start][end]=ans;
        return dp[start][end];
        
    }
    public static int getMax(int s, int e, int [] arr){
        int max=Integer.MIN_VALUE;
        for(int i=s; i<=e;i++){
            max=Math.max(max,arr[i]);
        }
        
        return max;
    }

}
