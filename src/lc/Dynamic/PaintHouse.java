package lc.Dynamic;

public class PaintHouse {

	static int minCost=Integer.MAX_VALUE;
	static int res=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][]cost= new int[][] {{17,2,17},{16,16,5},{14,3,19}};
		/*
		 * here the main thing is at each row we check the min value with that colour + min value till previous row
		 * 
		 * in the first row= let r= 17 cost  b = 2 cost  g=17 since that is the minimum cost for each colour in that row
		 * now coming to second row if we choose r then we must calculate the value of either b or g since adjacent same colour not possibe
		 * so what to choose we will choose the min(b,g) which is 2
		 * like wise we calculate for each row and for each colour.
		 * 
		 * npw at the last column we have values at choosing each colour we have to return min value in that row
		 * cos in that [r][c] value we have cost of that colour+ plus cost of all previous rows optimal.
		 * 
		 * https://www.youtube.com/watch?v=o5Ub2Tw8Tvg&t=1394s
		 *
		 */
		for(int i=1; i< cost.length;i++) {
			cost[i][0]+= Math.min(cost[i-1][1],cost[i-1][2]);
			cost[i][1]+= Math.min(cost[i-1][0],cost[i-1][2]);
			cost[i][2]+= Math.min(cost[i-1][1],cost[i-1][0]);
		}
		
		System.out.println(Math.min(Math.min(cost[cost.length-1][0], cost[cost.length-1][1]), cost[cost.length-1][2]));

	}


	

}
