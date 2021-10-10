package leetCode30Day;

public class D18_MinPathSUm {
	
	static int sum= 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid= new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(minPathSum(grid));

	}

	public static int minPathSum(int[][] grid) {
		
		int i= grid.length-1;
		if(i<0)
			return 0;
		
		int j= grid[0].length-1;
		
		//helper(grid,i,j);
		return helperDP(grid);
		
		//return sum;

	}

	private static int helperDP(int[][] grid) {

		System.out.println(sum);
		for(int i=0;i<=grid.length-1;i++ ) {
			for(int j=0; j <=grid[i].length-1;j++) {
				if(i==0 && j==0)
					continue;
				else if(i==0 && j!=0) {
					grid[i][j] += grid[i][j-1];
				}
				else if(j==0 && i!=0) {
					grid[i][j] += grid[i-1][j];
				}
				else {
					grid[i][j] +=Math.min(grid[i][j-1], grid[i-1][j]);
				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}

	private static int helper(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		
		if(i <0 || j <0)
			return 0;
		
		if(i==0 && j==0 )
			return grid[i][j];
		
		if(i ==0 && j!=0) {
			sum += grid[i][j]+ helper(grid,i,j-1); 
		}
		else if(j==0 && i != 0) {
			sum += grid[i][j]+ helper(grid,i,j-1);
		}
		else {
			sum += grid[i][j]+ Math.min(helper(grid,i,j-1), helper(grid,i-1,j));
		}
		
		return sum;
		
	}

}
