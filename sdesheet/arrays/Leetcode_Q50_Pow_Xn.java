package arrays;

public class Leetcode_Q50_Pow_Xn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(2.0,-6));

	}

	public static double myPow(double x, int n) {

		if (n == 0)
			return 1;
		else if (n < 0) {
			/*
			 * here 2 solution
			 * since int negative has overflow if we convert into positive we do a trick
			 * basically divide by 1/x then convert the power to positive
			 */
			// n = -(n+1);
			// return 1/x*myPow(1/x,n);
			/*
			 * second solution is down  in case of positive if power = -6  it divide and in any case it will always arrive at 1 in the end
			 * so for odd we do the 1/x
			 */
			return n % 2 == 0 ? myPow(x * x, n / 2) : 1 / x * myPow(x * x, n / 2);

		} else
			return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
			/*
			 * in case of positive num
			 * to have bin search on answer
			 *  if   4^4  then we can do (4*4)^2  if odd =  4^5 then = 4*(4*4)^2
			 */

	}

}
