package practice.Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTrapping2Pointer {

	static List<Integer> lis= new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lis= Arrays.asList(new Integer[] {4,2,0,3,2,5});
		solve();
		///    https://www.youtube.com/watch?v=lhzrp3Nbj-w Stack based solution

	}

	private static void solve() {
		// TODO Auto-generated method stub
		int l=0,r=lis.size()-1;
		int lMax=lis.get(0);
		l++;
		int rMax=lis.get(lis.size()-1);
		int water=0;
		while(l<r) {
			if(lis.get(l)<lis.get(r)) {
				if(lis.get(l)>lMax)
					lMax=lis.get(l);
				else
					water+=(lMax-lis.get(l));
				l++;
			}
			else {
				if(lis.get(r)>rMax)
					rMax=lis.get(r);
				else
					water+=(rMax-lis.get(r));
				
				r--;
				
			}
		}
		System.out.println(water);
	}

}
