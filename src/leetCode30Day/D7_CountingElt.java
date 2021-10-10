package leetCode30Day;

import java.util.Arrays;
import java.util.HashMap;

public class D7_CountingElt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {1,2,3};
		
		//Arrays.stream(countElt(arr)).forEach(System.out::print);
		System.out.println(countElt(arr));

	}

	private static int countElt(int[] arr) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer>hm = new HashMap<>();
		for(int a: arr) {
			hm.put(a, hm.getOrDefault(a, 0)+1);
		}
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(hm.containsKey(arr[i]+1) && hm.get(arr[i]+1) > 0) {
				count++;
				//hm.put(arr[i]+1, hm.get(arr[i]+1)-1);
			}

		}
		return count;
	}

}
