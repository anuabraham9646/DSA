package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StockSpanStack {

	static List<Integer> ip= Arrays.asList(new Integer[]{100,80,60,199,70,60,185});
	static List<Integer> ans= new ArrayList<>();
	private static Stack<Integer> s= new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		stockSpan();
		//Collections.reverse(ans);
		ans.stream().forEach(a -> System.out.print(a +" "));
	}
	private static void stockSpan() {
		// TODO Auto-generated method stub
		for(int i=0;i<ip.size();i++) {
			if(s.isEmpty()) {
				ans.add(i, i+1);
			}
			else if(ip.get(i)< ip.get(s.peek())) {
				int diff= i- s.peek();
				ans.add(i,diff);
			}
			else {
				while(!s.isEmpty() && ip.get(i) >= ip.get(s.peek())) {
					s.pop();
				}
				if(s.isEmpty()) {
					ans.add(i, i+1);
				}
				else if(ip.get(i)< ip.get(s.peek())) {
					int diff= i- s.peek();
					ans.add(i,diff);
				}
			}
			s.push(i);
		}
		
	}

}
