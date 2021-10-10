package arrays;

public class Leetcode_Q48_RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		rotate(arr);
	}

	public static void rotate(int[][] matrix) {
		/*
        intuition is that basically we have to me it downward perpendicularly
        so one thing like that is transpose
        but not complete we have to swap the left and right columns for final ans
    */
	//first transpose the matrix which can be done by swapping the symmetry elts.
	for(int i=0;i<matrix.length;i++) {
		for(int j=i;j<matrix[0].length;j++) {
			if(i==j)
				continue;
			int temp= matrix[i][j];
			matrix[i][j]= matrix[j][i];
			matrix[j][i]= temp;
		}
	}
    //now swap the left and right columns eg 0 -> 3| 1->2 
	int i=0,j=matrix[0].length-1;
	while(i<j) {
		for(int k=0;k<matrix.length;k++) {
			int temp= matrix[k][i];
			matrix[k][i]= matrix[k][j];
			matrix[k][j]= temp;
            
		}
        i++;
        j--;
	}

}

}
