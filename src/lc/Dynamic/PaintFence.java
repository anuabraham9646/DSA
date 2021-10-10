package lc.Dynamic;

public class PaintFence {
	/*
	 * The problem states that there are ’n’ fences which can be coloured with one
	 * of the ‘k’ colours in such a way that not more than two adjacent fences have
	 * the same colour.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		int k = 2;

		int dp[] = new int[n + 1];
		dp[0] = 0;// when no house there are no ways
		dp[1] = k; // when there is just 1 house we try all coulurs
		int same = 0, diff = 0;
		/*
		 * when there are 2 fences for same== we have k colours and colour both same to
		 * have k ways for different == for first fence we have k ways for 2nd fence we
		 * have k-1 ways cos 1 colour is used
		 * 
		 */
		same = k;
		diff = k * (k - 1);
		dp[2] = same + diff;

		/*
		 * for 3 fence suppose we use same colour as previous then by conditon the 1st
		 * fence and 2nd has to be different hence the same variable has to be equal to
		 * diff of previous dp
		 * 
		 * suppose we use different colour then diff= total ways of previous * k-1 k-1
		 * cos we have 1 less colour again.
		 * 
		 */
		for (int i = 3; i < dp.length; i++) {
			same = diff;
			diff = dp[i - 1] * (k - 1);

			dp[i] = same + diff;
		}
		
		System.out.println(dp[n]);

	}

}
