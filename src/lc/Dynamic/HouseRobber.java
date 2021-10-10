package lc.Dynamic;

public class HouseRobber {

	static int val=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= new int[] {2,7,9,3,1};
		
		System.out.println(rec(arr,arr.length-1));
		
		int dp[]= new int[arr.length+1];
		dp[0]=0;
		dp[1]= arr[0];
		dp[2]= Math.max(arr[1],arr[0]);
		
		for(int i=3;i< dp.length;i++) {
			dp[i]= Math.max(arr[i-1]+dp[i-2], dp[i-1]);
		}
		
		
		System.out.println(dp[5]);

	}

	private static int rec(int[] arr, int i) {
		// TODO Auto-generated method stub
		if(i <0 )
			return 0;
		
		
		/*
		 * it means we can either rob that house theen we cant rob(i-1) so we must rob i-2house
		 * or else we dont rob that house we go to i-1 house
		 * and we need to find the maximum of which one has to be robbed
		 */
		val= Math.max(arr[i]+rec(arr,i-2), rec(arr,i-1));
		
		return val;
	}

}
