package practice.Stack;

import java.util.Stack;

public class OnlineStockSpanQ901 {

	Stack<int[]> s;
	int[]arr= new int[100];
	int[]prices= new int[100];
	int count;
	int top;
	public OnlineStockSpanQ901() {
		s = new Stack<>();
		count = 0;
		top=-1;
	}

	public int next(int price) {
		int res = 1;
		
		while(!s.isEmpty() && price >= s.peek()[1]) {
			s.pop();
		}
		if(s.isEmpty()) res= count+1;
		else res= count- s.peek()[0];
		s.push(new int[] {count,price});
		count++;
		return res;
		
		
	}
	public int nextArray(int price) {
		int res=0;
		prices[count]=price;
		while(top >=0 && price >= prices[arr[top]]) {
			top--;
		}
		if(top== -1)
			res= count+1;
		else
			res= count- arr[top];
		arr[++top]=count;
		count++;
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnlineStockSpanQ901 o= new OnlineStockSpanQ901();
		System.out.println(o.next(100));
		System.out.println(o.next(80));
		System.out.println(o.next(60));
		System.out.println(o.next(70));
		System.out.println(o.next(60));
		System.out.println(o.next(75));
		System.out.println(o.next(85));
		System.out.println("-----------------------");
		OnlineStockSpanQ901 o2= new OnlineStockSpanQ901();
		System.out.println(o2.next(100));
		System.out.println(o2.next(80));
		System.out.println(o2.next(60));
		System.out.println(o2.next(70));
		System.out.println(o2.next(60));
		System.out.println(o2.next(75));
		System.out.println(o2.next(85));

	}
	

}
