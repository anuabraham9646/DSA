package leetcodeMay30Day;

import java.util.Arrays;

public class FindTheTownJudge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}};
		System.out.println(helper(arr,4));

	}

	private static int helper(int[][] arr, int N) {
		// TODO Auto-generated method stub
		int []count= new int[N+1];
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i][0]]--;
			count[arr[i][1]]++;
		}
		
		for(int i=1;i <=N;i++) {
			if(count[i]== N-1) return i;
		}
		return -1;
	}

}
