package practice.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stock[] = new int[] { 10, 4, 5, 90, 120, 80 };
		Arrays.stream(getStockSpan(stock)).forEach(System.out::print);

	}

	private static int[] getStockSpan(int[] stock) {
		// TODO Auto-generated method stub
		Stack<Integer> sIndex = new Stack<>();
		int[] res = new int[stock.length];
		
		// first value will always have length 1 and we store index
		// index stores cos using NGE we only have 1 value here we should know range of values
		// Instead of 2 stack we can push and pop index of values
		res[0] = 1;
		sIndex.push(0);
		for (int i = 1; i < stock.length; i++) {
			/*
			 * if reached at empty stack hence all value in left less or equal
			 * hence value is that index itslef eg index=2 means all 3 values are less or equal 
			 */
			if (sIndex.isEmpty()) 
				res[i] = i + 1;

			/*
			 * if current top value is great
			 * that means till previous top values were less or equal
			 * top= 1  curr= 4 in between 2 3 and 4 we less and equal hence 4-1
			 */
			else if (!sIndex.isEmpty() && stock[sIndex.peek()] > stock[i])
				res[i] = i - sIndex.peek();

			else if (!sIndex.isEmpty() && stock[sIndex.peek()] <= stock[i]) {

				while (!sIndex.isEmpty() && stock[sIndex.peek()] <= stock[i])
					sIndex.pop();

				if (sIndex.isEmpty())
					res[i] = i + 1;
				else
					res[i] = i - sIndex.peek();

			}
			sIndex.push(i);
		}
		return res;
	}

}
