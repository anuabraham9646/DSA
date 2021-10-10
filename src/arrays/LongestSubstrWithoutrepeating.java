package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutrepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "tmmzuxtt";
		// twwzuxt
		System.out.println(lengthOfLongestSubstring(s));

	}

	private static int lengthOfLongestSubstring(String s) {
		// TODO Auto-generated method stub
		int maxLen = 0, len = 0;
		Map<Character, Integer> hm = new HashMap<>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (!hm.containsKey(s.charAt(i))) {
				hm.put(s.charAt(i), i);
				len = i - j+1;
				maxLen = Math.max(len, maxLen);
			} else {

				j = Math.max(j, hm.get(s.charAt(i)) + 1);
				len = i - j+1;
				maxLen = Math.max(len, maxLen);
				hm.put(s.charAt(i),i);
			}
		}

		return maxLen;
	}

}
