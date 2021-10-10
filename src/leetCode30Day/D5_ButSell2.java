package leetCode30Day;

public class D5_ButSell2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {7,1,5,3,6,4};
		System.out.println(Stock(arr));

	}

	private static int Stock(int[] arr) {
		// TODO Auto-generated method stub
		int profit=0;
		int min= Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < min) {
				min= arr[i];
			}else {
				
			}
		}
		return profit;
	}

}
