package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class AlmostKSortedArray {
/*
 * https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 * this array is almost sorted each element is atmost k places displaced from its sorted position either on left or right
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int  arr[] = new int []{6, 5, 3, 2, 8, 10, 9};
		int k=3;
		
		kSorted(arr,k);

	}

private static void kSorted(int[] arr, int k) {
	// TODO Auto-generated method stub
	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	ArrayList<Integer> res= new ArrayList<Integer>();
	//int j=0;
	for(int a : arr) {
		if(k-- >=0)
			minHeap.add(a);
		else {
			if(a < minHeap.peek())
				res.add(a);
			else {
				res.add(minHeap.poll());
				minHeap.add(a);				
			}
		}
	}
	while(!minHeap.isEmpty())
		res.add(minHeap.poll());
	res.stream().forEach(a -> System.out.print(a +" "));
}

}
