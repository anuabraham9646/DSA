package leetCode30Day;

public class D26_LCS {

	static int max=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * "ezupkr"
"ubmrapg"
		 */
		String s = "ezupkr";
		String s1 = "ubmrapg";
		System.out.println(longestCommonSubsequence(s,s1));

	}

	private static int longestCommonSubsequence(String s, String s1) {
		return recursive(s,s1,s.length()-1,s1.length()-1);
		//int[][] dp= new int[s.length()+1][s1.length()+1];
		//return memo(s,s1,dp);

	}

	private static int memo(String s, String s1, int[][] dp) {
		// TODO Auto-generated method stub
		for(int i=0 ; i<=s.length();i++)
			dp[i][0]=0;
		for(int i=0 ; i<=s1.length();i++)
			dp[0][i]=0;
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<= s1.length();j++) {
				if(s.charAt(i-1)==s1.charAt(j-1)) {
					//max++;
					dp[i][j]=1+dp[i-1][j-1];
				}else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[s.length()][s1.length()];
	}

	private static int recursive(String s, String s1, int i, int j) {
		// TODO Auto-generated method stub
		if(i <0 || j <0)
			return max;
		if(s.charAt(i)==s1.charAt(j)) {
			max=recursive(s,s1,i-1,j-1)+1;
			
			
		}
		else {
			max= Math.max(recursive(s,s1,i-1,j), recursive(s,s1,i,j-1));
		}
		
		return max;
	}

}
