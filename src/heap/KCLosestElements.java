package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KCLosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int []{10, 2, 14, 4, 7, 6};
		int x = 7;
		int k = 4;
		solve(arr,x,k);

	}

	private static void solve(int[] arr, int x, int k) {
		
		int []a= new int[arr.length];
		List<List<Integer>> t= new ArrayList<List<Integer>>();
		for(int i=0;i< arr.length;i++) {
			a[i]=Math.abs(arr[i]-x);
			List<Integer> tt= new ArrayList<Integer>();
			tt.add(a[i]);
			tt.add(arr[i]);
			t.add(tt);
		}
		
		PriorityQueue<List<Integer>> max = new PriorityQueue<>((List<Integer> la,List<Integer> lb) -> lb.get(0)-la.get(0)); 
		for(int i=0;i<t.size();i++) {
			if(k-- >0)
				max.add(t.get(i));
			else {
				if(t.get(i).get(0)<max.peek().get(0))
				{
					max.poll();
					max.add(t.get(i));
				}
			}
		}
		
		//System.out.println(max.size());
		max.stream().forEach(z -> System.out.print(z.get(1)+" "));
		
	}

}
