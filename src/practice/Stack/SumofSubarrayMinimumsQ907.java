package practice.Stack;

public class SumofSubarrayMinimumsQ907 {
	/*
	 * Given an array of integers A, find the sum of min(B), where B ranges over
	 * every (contiguous) subarray of A.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 3, 1, 2 ,2};
		System.out.println(helper(arr));

	}

	private static int helper(int[] arr) {
		// TODO Auto-generated method stub
		int [] nxtSmall= new int[arr.length];
		int [] prvSmall= new int[arr.length];
		int temp[]= new int[arr.length];
		int top=-1;
		for(int i=0;i<arr.length;i++) {
			while(top>=0 && arr[i] < arr[temp[top]]) {
				nxtSmall[temp[top]]= i-temp[top--];
			}
			temp[++top]= i;
		}
		while(top!=-1) {
			nxtSmall[temp[top]]=arr.length-temp[top--];
		} //3, 1, 2,2
		for(int i=0;i< arr.length;i++)
			System.out.print(" "+nxtSmall[i]);
		top=-1;
		System.out.println(" --------");
		for(int i=0;i<arr.length;i++) {
			while(top>=0 && arr[i] < arr[temp[top]]) {
				top--;
			}
			prvSmall[i]= top==-1? i+1 : i- temp[top] ;
			temp[++top]= i;
		}
		for(int i=0;i< arr.length;i++)
			System.out.print(" "+prvSmall[i]);
		int sum=0;
		int mod=(int) (Math.pow(10, 9)+7);
		for(int i=0;i< arr.length;i++)
			sum= (sum +arr[i]*prvSmall[i]*nxtSmall[i]) % mod;
			
		
		return sum;
	}

}
