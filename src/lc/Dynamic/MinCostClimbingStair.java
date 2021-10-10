package lc.Dynamic;

public class MinCostClimbingStair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= new int[] {1,100,1,1,1,100,1,1,100,1};
		//System.out.println(helperRec(arr,arr.length-1));
		
		System.out.println(helperDP(arr));

	}

	private static int helperDP(int[] arr) {
		// TODO Auto-generated method stub
		
		int n= arr.length;
        int dp[]= new int[n+1];
		dp[0]= arr[0];
		dp[1]=arr[1];
		for(int i=2;i< n+1;i++) {
            if(i == dp.length-1)
                dp[i]=Math.min(dp[i-1], dp[i-2]);
            else
                dp[i]= arr[i]+ Math.min(dp[i-1], dp[i-2]);
		}
        
		return dp[n];
	}

	private static int helperRec(int[] arr, int i) {
		// TODO Auto-generated method stub
		
		if(i==1 || i==0)
			return arr[i];
		
		else {
			return arr[i]+Math.min(helperRec(arr,i-1), helperRec(arr,i-2));
		}
	}

}
