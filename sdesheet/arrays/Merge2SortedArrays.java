package arrays;

public class Merge2SortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]= new int[] {1, 5, 9, 10, 15, 20};
		int arr2[]= new int[] {2, 3, 8, 13};
		
		solve1(arr,arr2);
		
		for(int ii=0;ii<arr.length;ii++) System.out.print(arr[ii]+" ");
		  System.out.println(""); for(int ii=0;ii<arr2.length;ii++)
		  System.out.print(arr2[ii]+" "); System.out.println("");
		  System.out.println("");

	}

	private static void solve1(int[] arr, int[] arr2) {
		int n= arr.length-1;
		int i=0;
		while(i<=n ) {
			if(arr[i] <= arr2[0])
				i++;
			else {
				int temp=arr2[0];
				arr2[0]=arr[i];
				arr[i]=temp;
				
				populateRightplace(0,arr2);
				i++;
			}
			
		}
		
	}

	private static void populateRightplace(int j, int[] arr2) {
		// TODO Auto-generated method stub
		int temp=arr2[j];
		for(int i=1;i<arr2.length && arr2[i] <= temp;i++) {
			arr2[i-1]=arr2[i];
			j=i;
		}
		
		
		arr2[j]=temp;
		
	}

}
