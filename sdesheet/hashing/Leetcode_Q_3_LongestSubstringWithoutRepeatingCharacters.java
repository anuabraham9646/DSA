package hashing;

import java.util.HashMap;

public class Leetcode_Q_3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lengthOfLongestSubstring("pwwkew");

	}

	public static int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        int len=0;
        int maxLen=0;
        int leftwindowStart=0;
        for(int i=0;i<s.length();i++) {
        	if(!map.containsKey(s.charAt(i))) {
        		len++;
        		map.put(s.charAt(i), i);
        	}
        	else {
        		int prevPos= map.get(s.charAt(i));
        		leftwindowStart=prevPos<leftwindowStart?leftwindowStart:prevPos;
        		len=i-leftwindowStart;
        		map.put(s.charAt(i), i);
        	}
        	maxLen= Math.max(maxLen, len);
        }
        
        System.out.println(maxLen);
        return maxLen;
    }

}
