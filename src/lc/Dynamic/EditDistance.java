package lc.Dynamic;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "intention";
		String s2= "execution";
		
		System.out.println(recursive(s1,s2,0,0));
		
		int dp[][]= new int[s1.length()][s2.length()];
        for(int[] temp : dp)
            Arrays.fill(temp,-1);
        System.out.println(memo(s1,s2,0,0,dp));

	}

	private static int memo(String a, String b , int i, int j, int[][] dp){
        if(i == a.length())
            return b.length()-j;
        if(j == b.length())
			return a.length()-i;
        
        
        if(dp[i][j] != -1)
            return dp[i][j];
        else{
            if(a.charAt(i)== b.charAt(j))
				dp[i][j]= 0+memo(a,b,i+1,j+1,dp);
			else {
				dp[i][j] = 1+ Math.min(memo(a,b,i,j+1,dp), Math.min(memo(a,b,i+1,j,dp),                                         memo(a,b,i+1,j+1,dp)));
			}
            return dp[i][j];
            
        }
    }

	private static int recursive(String s1, String s2, int i, int j) {
		// TODO Auto-generated method stub
		
		/*
		 * here if the first string is completed fully
		 * then whatever is remaining of the 2nd string length is the 
		 * amount of changes required
		 */
		if(i == s1.length())
			return s2.length()-j;
		//same thing for the other string
		if(j == s2.length())
			return s1.length()-i;
		else {
			
			// if char at i == j then do nothing and move 1 index up for both string
			if(s1.charAt(i)== s2.charAt(j))
				return 0+recursive(s1,s2,i+1,j+1);
			else {
				/*
				 * if char at i is not equal then 3 possibility
				 *  1 insertion
				 *  a: bcd
				 *  b:abcd  then what we do is we wont move i cos in next iteration we have to check bcd
				 *  we move j by 1 and skip the char a and left with bcd
				 *  
				 *  2 deletion
				 *  a :bghi
				 *  b : ghi
				 *  we move i by 1 and make it ghi
				 *  we wont move j because its already ghi hence we simulating the removal and not actual removal
				 *  
				 *   
				 *   3 replace
				 *   a:abc
				 *   b:dbc
				 *   we replace the char a to d and move
				 *   i and j by 1 index
				 *   
				 *   and we count that as 1 change and minimum of all recursive changes
				 */
				int result = 1+ Math.min(recursive(s1,s2,i,j+1), Math.min(recursive(s1,s2,i+1,j), recursive(s1,s2,i+1,j+1)));
				 return result;
			}	
		}
	}

}
