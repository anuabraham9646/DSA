package array;

public class Leetcode_Q88_MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {1,2,3,0,0,0};
		int arr2[]= new int [] {2,5,6};
		merge(arr,3,arr2,3);

	}
	public static void merge(int[] num1, int m, int[] num2, int n) {
        int num1Itr= m-1,num2Itr=n-1,total= num1.length-1;
        
        while(num1Itr>=0 && num2Itr>=0){
            if(num1[num1Itr]>=num2[num2Itr])
                num1[total--]=num1[num1Itr--];
            else
                num1[total--]=num2[num2Itr--];
        }
        
        /*
            we only consider the 2nd array because there are 3 cases
            1 where the array 1 is not empty in that case since the 1st array is sorted
            no need to poke it
            2 if the array 2 is not fully checked we are using the 2nd loop below
            3 when both array are checked then the sorting stops
        */
        while(num2Itr >=0)
            num1[total--]=num2[num2Itr--];
        
    }

}
