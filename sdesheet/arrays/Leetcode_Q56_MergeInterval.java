package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_Q56_MergeInterval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][]= new int [][] {{13,21},{1,3},{15,18},{2,6},{8,10}};
		
		int [][]res=merge(intervals);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j < 2;j++)
				System.out.print(res[i][j]+" ");
			System.out.println("");
		}
	}

	private static int[][] merge(int[][] intervals) {
		if(intervals.length<=0)
			return intervals;
		Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
		
		List<int[]> res= new ArrayList<>();
		
		res.add(new int[] {intervals[0][0],intervals[0][1]});
		
		for(int i=1;i< intervals.length;i++) {
			if(intervals[i][0] <= res.get(res.size()-1)[1]) {
				if(intervals[i][1] <= res.get(res.size()-1)[1])
					continue;
				res.get(res.size()-1)[1]=intervals[i][1];
			}
				
			else {
				res.add(new int[] {intervals[i][0],intervals[i][1]});
			}
			
		}
		int[][] finalResult = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++)
        {
            finalResult[i] = res.get(i);
        }
        
        return finalResult;
		
	}

}
