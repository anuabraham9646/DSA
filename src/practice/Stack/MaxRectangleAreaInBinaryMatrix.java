package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MaxRectangleAreaInBinaryMatrix {

	static List<List<Integer>> matrix= new ArrayList<>();
	public static void main(String[] args) {
		List<Integer>a= Arrays.asList(new Integer [] {0,1,1,0});
		List<Integer>b= Arrays.asList(new Integer [] {1,1,1,1});
		List<Integer>c=  Arrays.asList(new Integer [] {1,1,1,1});
		List<Integer>d= Arrays.asList(new Integer [] {1,1,0,0});
		matrix.add(a);
		matrix.add(b);
		matrix.add(c);
		matrix.add(d);
		solve();

	}
	private static void solve() {
		List<Integer> heights=new ArrayList<>();
		int maxArea=0;
		int area=0;
		for(int i=0;i <matrix.size();i++) {
			if(i==0) {
				heights= matrix.get(0);
			}
			else {
				for(int j=0;j< matrix.get(i).size();j++) {
					if(matrix.get(i).get(j)==0)
						heights.set(j, 0);
					else
						heights.set(j, heights.get(j)+1);
				}
			}
			area= findMaxArea(heights);
			maxArea=Math.max(area, maxArea);
		}
		
		System.out.println("Max area is = "+maxArea);
	}
	private static int findMaxArea(List<Integer> heights) {
		// TODO Auto-generated method stub
		Stack<Integer> NSL= new Stack<>();
		ArrayList<Integer> ansL= new ArrayList<>();
		Stack<Integer> NSR= new Stack<>();
		ArrayList<Integer> ansR= new ArrayList<>();
		nsl(NSL,heights,ansL);
		nsr(NSR,heights,ansR);
		int area=0,maxArea=0;
		for(int i=0;i< heights.size();i++) {
			int left = ansL.get(i);
			int right= ansR.get(i);
			area= heights.get(i)*(left+right-1);
			maxArea=Math.max(area, maxArea);
		}
		return maxArea;
	}
	private static void nsr(Stack<Integer> s, List<Integer> heights, ArrayList<Integer> ansR) {
		int size= heights.size();
		for(int i=size-1;i>= 0;i--) {
			if(s.isEmpty()) {
				ansR.add(size-i);
			}
			else if(heights.get(i) > heights.get(s.peek())){
				ansR.add(s.peek()-i);
			}
			else {
				while(!s.isEmpty() && heights.get(i) <= heights.get(s.peek()))
					s.pop();
				if(s.isEmpty()) {
					ansR.add(size-i);
				}
				else if(heights.get(i) > heights.get(s.peek())){
					ansR.add(s.peek()-i);
				}
			}
			s.push(i);
		}
		Collections.reverse(ansR);
		
	}
	private static void nsl(Stack<Integer> s, List<Integer> heights, ArrayList<Integer> ansL) {
		for(int i=0;i< heights.size();i++) {
			if(s.isEmpty()) {
				ansL.add(i+1);
			}
			else if(heights.get(i) > heights.get(s.peek())){
				ansL.add(i-s.peek());
			}
			else {
				while(!s.isEmpty() && heights.get(i) <= heights.get(s.peek()))
					s.pop();
				if(s.isEmpty()) {
					ansL.add(i+1);
				}
				else if(heights.get(i) > heights.get(s.peek())){
					ansL.add(i-s.peek());
				}
			}
			s.push(i);
		}
		
	}

}
