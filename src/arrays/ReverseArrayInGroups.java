package arrays;

import java.util.Arrays;

public class ReverseArrayInGroups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 5,6,8,9 };
		//System.out.println(helper(arr, 3));
		helper(arr, 7);

	}

	private static void helper(int[] arr, int k) {
		// TODO Auto-generated method stub
		k--;
		int low = 0;
		int curMax = low + k;
		int runMax = low + k;
		int temp = 0;
		while (true) {

			if (curMax >= arr.length - 1)
				break;
			while (low < runMax) {
				temp = arr[low];
				arr[low]= arr[runMax];
				arr[runMax]=temp;
				low++;
				runMax--;
			}
			low=curMax+1;
            curMax+=k+1;
            runMax=curMax;
			
		}
		
		//low=curMax+1;
        
        if (low < arr.length-1) {
			runMax = arr.length - 1;
			while (low < runMax) {
				temp = arr[low];
				arr[low] = arr[runMax];
				arr[runMax] = temp;
				low++;
				runMax--;
			} 
		}
		for(int i=0;i< arr.length;i++) {
			//System.out.println("h");
			System.out.println(arr[i]);
		}
			
	}

}
