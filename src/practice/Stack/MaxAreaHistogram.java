package practice.Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {2,1,5,6,2,3}; 
		/*
		 * here at every value we must go to the right till we encounter a value smaller than it
		 * also go to left till a value smaller is encountered that is for each value in array
		 * hence it is effectively creating next smaller element array in right and left
		 *  
		 */
		
		System.out.println("Max area is "+maxHistogram(arr));

	}

	private static int maxHistogram(int[] arr) {
		// TODO Auto-generated method stub
		int maxVal=0;
		
		int [] nsl=new int[arr.length];
		int [] nsr=new int[arr.length];
		Stack<Integer> sInd= new Stack<>();
		
		calcNSL(nsl,arr,sInd);
		//Arrays.stream(nsl).forEach(System.out::print);
		sInd.clear();
		calcNSR(nsr,arr,sInd);
		Arrays.stream(nsl).forEach(System.out::println);
		System.out.println("---------");
		Arrays.stream(nsr).forEach(System.out::println);
		/*System.out.println("");
		Arrays.stream(nsr).forEach(System.out::print);*/
		for(int i=0;i< arr.length;i++) {
			int width= nsr[i]-nsl[i]-1;
			maxVal=Math.max(maxVal, width*arr[i]);
			
			System.out.print(" "+width*arr[i]);
		}
		return maxVal;
	}

	private static void calcNSR(int[] nsr, int[] arr, Stack<Integer> sInd) {
		
		nsr[arr.length-1]=arr.length;
		sInd.push(arr.length-1);
		for(int i= arr.length-2;i>=0;i--) {
			if(sInd.isEmpty())
				nsr[i]=arr.length;
			//if()
			else if(!sInd.isEmpty() && arr[sInd.peek()] < arr[i])
				nsr[i]= sInd.peek();
			
			else if(!sInd.isEmpty() && arr[sInd.peek()] >= arr[i]) {
				while(!sInd.isEmpty() && arr[sInd.peek()] >= arr[i])
					sInd.pop();
				if(sInd.isEmpty())
					nsr[i]=arr.length;
				else
					nsr[i]= sInd.peek();
			}
				
			sInd.push(i);
		}
		
	}

	private static void calcNSL(int[] nsl, int[] arr, Stack<Integer> sInd) {
		// TODO Auto-generated method stub
		nsl[0]=-1;
		sInd.push(0);
		for(int i=1;i< arr.length;i++) {
			if(sInd.isEmpty())
				nsl[i]=-1;
			else if(!sInd.isEmpty() && arr[sInd.peek()] < arr[i])
				nsl[i]=sInd.peek();
			
			else if(!sInd.isEmpty() && arr[sInd.peek()] >= arr[i]) {
				while(!sInd.isEmpty() && arr[sInd.peek()] >= arr[i])
					sInd.pop();
				if(sInd.isEmpty())
					nsl[i]=-1;
				else
					nsl[i]=sInd.peek();
				
			}
			sInd.push(i);
		}
		
		
	}

}
