package leetCode30Day;

import java.util.Stack;

public class D8_BackSpaceStringCmpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "ab#c";//"j##yc##bs#srqpfzantto###########i#mwb";
		String T = "ad#c";//"j##yc##bs#srqpf#zantto###########i#mwb";
		System.out.println(backspaceCompare(S, T));

		System.out.println(optimalSoln(S, T));

	}

	private static boolean optimalSoln(String s, String t) {
		// TODO Auto-generated method stub
		int i = s.length() - 1;
		int j = t.length() - 1;
		int scnt = 0;
		int tcnt = 0;
		while (i >= 0 || j >= 0) {
			while (i >=0) {
				if (s.charAt(i) == '#') {
					scnt++;
					i--;
				}else if(s.charAt(i) != '#' && scnt >0) {
					scnt--;
					i--;
				}else
					break;
			}
			
			while(j>=0) {
				if (t.charAt(j) == '#') {
					tcnt++;
					j--;
				}else if(t.charAt(j) != '#' && tcnt >0) {
					tcnt--;
					j--;
				}else
					break;
			}
			
			if(i==-1 && j== -1)
				return true;
			
			if(i==-1 || j== -1)
				return false;
			
			if(s.charAt(i) != t.charAt(j))
				return false;
			else {
				i--;
				j--;
			}
			
		}
		return true;

	}

	public static boolean backspaceCompare(String S, String T) {
		Stack<Character> s = new Stack<>();
		Stack<Character> t = new Stack<>();
		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == '#') {
				if (s.isEmpty())
					continue;
				else
					s.pop();
			} else {
				s.push(S.charAt(i));
			}
		}

		for (int i = 0; i < T.length(); i++) {

			if (T.charAt(i) == '#') {
				if (t.isEmpty())
					continue;
				else
					t.pop();
			} else {
				t.push(T.charAt(i));
			}
		}

		while (!s.isEmpty() && !t.isEmpty()) {
			if (s.pop() != t.pop())
				return false;
		}

		if (!s.isEmpty() || !t.isEmpty())
			return false;

		return true;
	}

}
