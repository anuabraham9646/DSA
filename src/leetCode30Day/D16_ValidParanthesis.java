package leetCode30Day;

import java.util.Stack;

public class D16_ValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkValidString("(*)(*()"));
		
		System.out.println(moreOptimalCheckValidString("(*)(*()"));

	}
	public static boolean moreOptimalCheckValidString(String s) {
		/*
		 * idea is that we predict  how many closing brackets will be required at each moment
		 * if our current one is'(' we require 1 if '((' we require 2 hence ( increment
		 * if our current one is'()' we require 0 if '(()' we require 1 hence ) decrements
		 * 
		 * now if we have'*' we can increment , decrement or let it be  '(* is either 0 or 1 or 2
		 * so it seems there is a max and min hence we create 2 vars 
		 * max and min
		 * when '*' we make min-=1,  max+=1
		 * when ')' we make min-=1 and max-=1 cos either way the requirement is reduced
		 * when '(' we make min+=1 and max+=1 cos either way the requirement is increased
		 * 
		 * 
		 * 
		 * IMP
		 * min is the minimum open paranthesis now 
		 * max is maximum paranthesis right now
		 * 
		 */
		int min=0,max=0;
		for(char c : s.toCharArray()) {
			if(c == '(') {
				min+=1;
				max+=1;
				
			}else if(c == ')') {
				
				min-=1;
				max-=1;
				if(max < 0)
					return false;
				
			}else {
				min-=1;
				max+=1;
			}
			
			min= Math.max(min, 0);
		}
		
		return min==0;
		
	}

	public static boolean checkValidString(String s) {

	
		Stack<Integer> open = new Stack<>();
		Stack<Integer> star = new Stack<>();

		/*
		 * we make use of 2 stack because we need to keep track of open braces and the
		 * position of stars therefore we store positions in each stacks
		 */

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(')
				open.push(i);

			else if (s.charAt(i) == '*')
				star.push(i);

			else {
				/*
				 * indicating only closing bracket left since our right bracket is at current
				 * positions and before right there should be mandatorily either a star or left
				 * bracket and subsequently we pop from the stack eg ( ( * * ) can be true but
				 * )* definitely  false if no values in stack it is already invalid
				 */
				if (open.isEmpty() && star.isEmpty())
					return false;
				/* 
				 * point to note we must first try for validate right bracket with open bracket if nothing comes
				 * then only if no hope we must use star
				 * as star can also mean nothing just to be safe side
				 * 
				 */

				else if (open.isEmpty()) {
					star.pop();
				} else
					open.pop();
			}
		}

		/*
		 * at this point we have balanced right bracket now opening brackets maybe not
		 * valid sequence we havent check so we go through the open stack here we will
		 * be matching with star stack and position of star > position of left bracket
		 * cos left bracket is starting hence the star should be on right eg- *( invalid
		 * but (* is valid
		 */
		while (!open.isEmpty()) {
			if(star.isEmpty())
				return false;
			if (star.peek() < open.peek()) {
				return false;
				// since top open bracket doesnt have anything as star is before it

			} else {
				open.pop();
				star.pop();
			}
		}

		return true;

	}

}
