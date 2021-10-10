package practice.Stack;

import java.util.*;

public class NextGreatElement2_Q503 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {1,2,1};
		Arrays.stream(helper(arr)).forEach(System.out::println);

	}

	private static int[] helper(int[] n2) {
		if (n2.length <= 0)
			return n2;
		int res[] = new int[n2.length];
        Arrays.fill(res,-1);
		Stack<Integer> s = new Stack<>();
		int n= n2.length;
		for (int i = 0; i < (n2.length)*2; i++) {
            
            while(!s.isEmpty() && (n2[i%n] > n2[s.peek()])){
                int val= s.pop();
                res[val]= n2[i%n];
            }
            
            if (i < n2.length)
				s.push(i);
		}
		return res;
	}

}
