package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGrtEltArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 1, 2, 1 };

		Arrays.stream(getGrtArray(arr)).forEach(System.out::println);

	}

	private static int[] getGrtArray(int[] arr) {
		// TODO Auto-generated method stub
		if (arr.length <= 0)
			return arr;

		int res[] = new int[arr.length];
		Stack<Integer> s = new Stack<>();
		// int curr;
		/*
		 * we index from right cos of the condition
		 */
		for (int i = arr.length - 1; i >= 0; i--) {
			/*
			 * if after popping if the stack becomes empty then there is no grt elt in right
			 * hence result= -1 and push the value in stack
			 */
			if (s.isEmpty()) {
				res[i] = -1;

			}
			/*
			 * ifthe elt on top is greater than current elt then stop the search result is
			 * top elt and push the current val in array
			 */
			else if (!s.isEmpty() && arr[i] < s.peek()) {
				int elt = s.peek();
				res[i] = elt;

			}
			/*
			 * after the other above condition if the value on top is less than current
			 * 
			 */
			else if (!s.isEmpty() && arr[i] >= s.peek()) {
				/*
				 * pop all the value in stack if its top is either small or till we reach empty
				 * stack
				 */
				while (!s.isEmpty() && arr[i] >= s.peek())
					s.pop();

				/*
				 * after the while is terminated 2 condition possible for that input either
				 * stack empty in that case res= -1 and push the val or else stack top greater
				 * than current hence result is stack top and push the value
				 */
				if (s.isEmpty()) {
					res[i] = -1;
				} else {
					int elt = s.peek();
					res[i] = elt;
				}

			}
			// since all case has push arr[i] hence we add it at end common

			s.push(arr[i]);
		}

		return res;
	}

}
