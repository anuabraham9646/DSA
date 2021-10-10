package arrays;

import java.util.*;

public class LongestEqualSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[] = new int[]  {0, 1, 0, 0, 0, 0};
		int arr2[] =  new int[] {1, 0, 1, 0, 0, 1};
		
		int longest= longestSum(arr1,arr2);
		System.out.println(longest);

	}
	public static int longestSum(int [] arr1, int [] arr2) {
		int maxLen=0;
		int len=0;
		int sum1=0,sum2=0;
		HashMap<Integer,HashMap<String,Integer>> differences= new HashMap<>();
		int n= arr1.length;
		for(int i=0;i<arr1.length;i++) {
			sum1+=arr1[i];
			sum2+=arr2[i];
			int diff= sum1-sum2;
			
			if(diff==0) {
				len= i+1;
			}
			else {
				if(differences.containsKey(diff)) {
					differences.get(diff).put("last", i);
					
					len= differences.get(diff).get("last")-differences.get(diff).get("first");
					
					differences.get(diff).put("len", len);
				}
				else {
					HashMap<String,Integer> hm= new HashMap<>();
					hm.put("first", i);
					differences.put(diff, hm);
					differences.get(diff).put("len", 1);
					differences.get(diff).put("last", -1);
					//differences.get(diff).put("first", i);
				}
			}
			if(len > maxLen)
				maxLen=len;
		}
		int max=-1;
		int start=-1,last=-1;
		
		for(HashMap<String, Integer> val : differences.values()) {
			if(val.get("len")> max) {
				start=val.get("first")+1;
				last=val.get("last");
				max= val.get("len");
			}
		}
		
		System.out.println("Starting at "+start + " ending at : "+last);
		
		return maxLen;
		
	}

}
