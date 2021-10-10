package practice.Stack;

import java.util.Stack;

public class RemoveAdjacentDuplicates {
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//removeDuplicates("abbaca");
		removeDuplicates2Pointer("abbaca");

	}

	private static void removeDuplicates2Pointer(String S) {
		StringBuffer res= new StringBuffer();
		int n=S.length();
		for(int j=0;j<n;j++) {
			res.append(S.charAt(j));
			//res.setCharAt(i, S.charAt(j));
			int len= res.length()-1;
			if(len >0 && res.charAt(len)==res.charAt(len-1)){
				res.deleteCharAt(len);
				res.deleteCharAt(len-1);
			}
		}
		System.out.println(res.toString());
	}

	private static void removeDuplicates(String S) {
		// TODO Auto-generated method stub
		Stack<Character> s= new Stack<>();
        for(int i=0;i< S.length();i++){
            if(s.isEmpty() || s.peek() != S.charAt(i))
                s.push(S.charAt(i));
            else
                s.pop();
        }
        StringBuffer ss= new StringBuffer();
        while(!s.isEmpty()) {
        	ss.append(s.pop());
        }
        
        System.out.println(ss.reverse().toString());

	}
	public void removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) { 
                sb.deleteCharAt(size - 1); 
            }else { 
                sb.append(c); 
            }
        }
        System.out.println(sb.toString());
    }

}
