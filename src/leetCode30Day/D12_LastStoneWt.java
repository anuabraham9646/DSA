package leetCode30Day;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class D12_LastStoneWt {

	public static void main(String[] args) {

		int stone[] = new int[] { 2, 7, 4, 1, 8, 1 };
		System.out.println(lastStoneWeight(stone));

	}

	public static int lastStoneWeight(int[] stones) {
	
		int stoneWt=0;
		Comparator<Integer> cmp= (a,b)-> b-a;
		Queue<Integer> heap= new PriorityQueue<>(cmp);
		
		int val1=0;
		int val2=0;
		for(int i : stones)
			heap.add(i);
		while(!heap.isEmpty()) {
			val1= heap.poll();
			
			if(heap.isEmpty())
				return val1;
			else
			{
				val2= heap.poll();
				if(val1!= val2)
					heap.add(val1-val2);
			}
		}
		System.out.println(heap.peek());
		
		return stoneWt;

	}

}
