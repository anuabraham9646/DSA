package arrays;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("racecar"));
	}

	public static String longestPalindrome(String s) {

		if (s.isEmpty() || s.length() == 1)
			return s;
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCentre(s, i, i);
			int len2 = expandAroundCentre(s, i, i + 1);

			int len = Math.max(len1, len2);

			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + (len / 2);
			}
		}

		return s.substring(start, end + 1);

	}

	private static int expandAroundCentre(String s, int L, int R) {
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}

		return R - L - 1;
	}

}
