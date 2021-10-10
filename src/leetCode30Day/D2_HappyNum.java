package leetCode30Day;

import java.util.HashSet;
import java.util.Set;

public class D2_HappyNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("is happy ?" + isHappy(19));

	}
/*
 * we have used the floyd cycle like we use to do in linked list cycle
 */
	public static boolean isHappy(int i) {

		int slow = i;
		int fast = i;
		do {
			slow = seq(slow);
			fast = seq(fast);
			if (fast == 1)
				return true;
			fast = seq(fast);
			System.out.println(slow + " " + fast);
			if (fast == 1)
				return true;
		} while (slow != fast);
		return false;

	}

	public static int seq(int i) {
		int sum = 0;
		while (i > 0) {

			sum += (i % 10 * i % 10);
			i /= 10;
		}
		System.out.println("sum" + sum);
		return sum;

	}

}
