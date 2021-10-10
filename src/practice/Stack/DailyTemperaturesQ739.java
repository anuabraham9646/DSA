package practice.Stack;

import java.util.Arrays;

public class DailyTemperaturesQ739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[]= new int[] {73, 74, 75, 71, 69, 72, 76, 73};
		Arrays.stream(helper(temp)).forEach(System.out::println);

	}

	private static int[] helper(int[] temp) {
		// TODO Auto-generated method stub
		int stack[]= new int[temp.length];
		int ans[]= new int[temp.length];
		int top= -1;
		for(int i=0;i< stack.length;i++) {
			while(top>=0 && temp[i]> temp[stack[top]]) {
				ans[stack[top]]=i-stack[top--];
			}
			stack[++top]=i;
			
		}
		
		return ans;
	}

}
