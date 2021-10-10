package leetcodeMay30Day;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "10200";

		int k = 1;

		// System.out.println( s+" "+s.charAt(0));
		System.out.println(helper(s, k));

	}

	private static String helper(String nums, int k) {
		
		Deque<Character> s = new ArrayDeque<>();
		/*
		 * if k > then we can remove all element and hence we will get 0
		 */
		if (k >= nums.length())
			return "0";
		for (int i = 0; i < nums.length(); i++) {
			/*
			 * suppose we see a current element which is bigger than the top of stack then 
			 * we pop stack if itsnot empty and push our value eg 193 9 is on top of stack
			 * and we hav 3 hence it would be wise to remove 9 and add 3
			 */
			while (k > 0 && !s.isEmpty() && (s.peek() > nums.charAt(i))) {
				s.pop();
				k--;
			}
			/*
			 * this is case when 102
			 * it become 02 and we dont need leading 0 we check if stack was empty and we are goin
			 * to push 0 then we dont push it
			 */
			if (s.isEmpty() && nums.charAt(i) == '0')
				continue;
			else
				s.push(nums.charAt(i));
		}

		while (k > 0) {
			/*
			 * this is for edge case 111
			 * while k is remaining we pop
			 */
			s.pop();
			k--;
		}
		StringBuilder ss = new StringBuilder();
		while (!s.isEmpty()) {
			ss.append(s.pop());
		}
		StringBuilder res = ss.reverse();

		// if nothing in string we return 0
		if (res.length() == 0)
			return "0";

		String result = res.toString();
		return result;
	}

}
