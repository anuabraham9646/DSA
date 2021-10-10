package arrays;
//https://www.techiedelight.com/inversion-count-array/
public class CountInversionsInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stubr
		
		int arr[]= new int[] {1, 20, 6, 4, 5};
		int n = arr.length-1;
		int temp[] = new int[n+1];
		
		int ans = mergesort(arr,0,n,temp);
		System.out.println(ans);

	}

	private static int mergesort(int[] arr, int lo, int hi, int[] temp) {
		// TODO Auto-generated method stub
		int count=0;
		
		if(lo < hi){
			int mid = lo +(hi-lo)/2;
			count+=mergesort(arr,lo,mid,temp);
			count+=mergesort(arr,mid+1,hi,temp);
			
			count+=merge(arr,lo,mid,hi,temp);
		}
		
		return count;
	}

	private static int merge(int[] arr, int lo, int mid, int hi, int[] temp) {
		// TODO Auto-generated method stub
		int i=lo;
		int j=mid+1;
		int k=lo;
		int count =0;
		while(i <=mid && j<=hi) {
			if(arr[i]<=arr[j])
				temp[k++]=arr[i++];
			else {
				temp[k++]=arr[j++];
				count+= mid-i +1;
			}
		}
		
		while(i <=mid)
			temp[k++]=arr[i++];
		while(j <=hi)
			temp[k++]=arr[j++];
		
		for(int t=lo;t<=hi;t++)
			arr[t]=temp[t];
		
		return count;
	}

}
