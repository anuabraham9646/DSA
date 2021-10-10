package array;

public class Leetcode_Q62_UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3, n = 7;
		System.out.println(uniquePaths(m,n));

	}

	public static int uniquePaths(int m, int n) {
		
		int [][]arr= new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(i==0 || j==0) 
					arr[i][j]=1;
				else
					arr[i][j]=0;
			}
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				arr[i][j]=Math.max(arr[i-1][j]+arr[i][j-1], arr[i][j]);
			}
		}
		return arr[m-1][n-1];

	}

}
