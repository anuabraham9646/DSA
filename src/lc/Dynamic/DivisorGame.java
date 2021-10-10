package lc.Dynamic;

public class DivisorGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(helper(6));

	}

	private static boolean helper(int i) {
		if(i <=1)
			return false;
		else {
			for(int j=1 ; j<i;j++) {
				if(i%j == 0 && !helper(i-j)) {
					return true;
				}
			}
			return false;
		}
	}

}
