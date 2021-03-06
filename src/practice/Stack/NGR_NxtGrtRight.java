package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NGR_NxtGrtRight {

	private static Stack<Integer> s= new Stack<>();
	private static List<Integer> ans= new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ip= new ArrayList<>();
		
		ip= Arrays.asList(new Integer[] {3,1,5,2,7,2});
		
		//System.out.println(ip.get(2));
		ngr(ip);
		Collections.reverse(ans);
		ans.stream().forEach(a -> System.out.println(a +" "));

	}
	private static void ngr(List<Integer> ip) {
		// TODO Auto-generated method stub
		for(int i= ip.size()-1; i>=0;i--) {
			if(s.isEmpty()) {
				ans.add(-1);
			}
			else if(s.peek() > ip.get(i)) {
				ans.add(s.peek());
			}
			else {
				while(!s.isEmpty() && s.peek()<= ip.get(i)) {
					s.pop();
				}
				if(s.isEmpty())
					ans.add(-1);
				else if(s.peek() > ip.get(i)) {
					ans.add(s.peek());
				}
					
			}
			s.push(ip.get(i));
		}
		
	}

}
