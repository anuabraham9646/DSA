package lc.Dynamic;

public class ClimbingStairs {

	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=6;
		System.out.println(rec(n));
		int []dp= new int [n+1];
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]= dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[n]);

	}
	
	private static int rec(int n) {
		// TODO Auto-generated method stub
		if(n<0)
			return 0;
		
		if(n < 2)
			return 1;
		
		return rec(n-1)+rec(n-2);
	}

}
