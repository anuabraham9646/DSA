package practice.Stack;

import java.util.*;

public class RemoveAdjacentDuplicates2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "deeedbbcccbdaa";
		int k=3;
		System.out.println(removeDuplicates(s,k));

	}

	public static String removeDuplicates(String s, int k) {
		// TODO Auto-generated method stub
		char[] a=s.toCharArray();
		int[]count = new int[s.length()];
		for(int i=0;i<s.length();i++) {
			a[i]= s.charAt(i);
			
			
		}
		return s;
	}

}
