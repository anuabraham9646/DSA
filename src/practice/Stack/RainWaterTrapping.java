package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RainWaterTrapping {

	static List<Integer> lis= new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lis= Arrays.asList(new Integer[] {4,2,0,3,2,5});
		solve();

	}
	private static void solve() {
		// TODO Auto-generated method stub
		List<Integer> rgtMax= new ArrayList<>();
		List<Integer> lftMax= new ArrayList<>();
		
		populateRgtMax(rgtMax);
		populateLftMax(lftMax);
				
		int area=findMaxArea(lftMax,rgtMax);
		System.out.println(area);
		
	}
	private static int findMaxArea(List<Integer> lftMax, List<Integer> rgtMax) {

		int area=0;
		for(int i=0;i<lis.size();i++) {
			if(lftMax.get(i) ==-1 || rgtMax.get(i) ==-1 || lis.get(i)>=lftMax.get(i) ||  lis.get(i)>=rgtMax.get(i))
				continue;
			else {
				int min= Math.min(lftMax.get(i), rgtMax.get(i));
				area += min-lis.get(i);
			}
		}
		
		return area;
	
	}
	private static void populateRgtMax(List<Integer> rgtMax) {
		// TODO Auto-generated method stub
		int curMax=-1;
		for(int i= lis.size()-1;i>=0;i--) {
			rgtMax.add(curMax);
			if(lis.get(i) > curMax )
				curMax= Math.max(curMax, lis.get(i));
			else
				continue;
		}
		Collections.reverse(rgtMax);
		
	}
	private static void populateLftMax(List<Integer> lftMax) {
		// TODO Auto-generated method stub
		int curMax=-1;
		for(int i= 0;i<lis.size();i++) {
			lftMax.add(curMax);
			if(lis.get(i) > curMax )
				curMax= Math.max(curMax, lis.get(i));
			else
				continue;
		}
		
	}
	

}
