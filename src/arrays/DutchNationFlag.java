package arrays;

import java.util.Arrays;

public class DutchNationFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= new int[] {2,0,2,1,1,0};
		
		help(arr);
		

	}

	private static void help(int[] arr) {

		int z=0;
		int t= arr.length-1;
		
		int k=0;
		while(k<=t) {
			
			if(arr[k]==0) {
				swap(arr,k,z);
				z++;
				k++;
			}
			else if(arr[k]==2) {
				swap(arr,k,t);
				t--;
			}
			else {
				k++;
			}
		}
		
		
		
		
		Arrays.stream(arr).forEach(x -> System.out.print(x+" "));
		
	}

	private static void swap(int[] arr, int k, int z) {


		int temp=arr[k];
		arr[k]=arr[z];
		arr[z]= temp;
		return;
		
	}

	
	
	
	

}
