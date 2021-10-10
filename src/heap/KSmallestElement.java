package heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] {7, 10, 4, 3, 20, 15};
		int k=2;
		
		kSmallest(arr,k);

	}

	private static void kSmallest(int[] arr, int k) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
		for(int a :arr) {
			if(k-- >0)
				maxHeap.add(a);
			else {
				if (a < maxHeap.peek()) {
					maxHeap.poll();
					maxHeap.add(a);
				}
				
			}
		}
		System.out.println(maxHeap.poll());
		
	}

}
