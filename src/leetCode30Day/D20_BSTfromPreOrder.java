package leetCode30Day;

import com.trees.BinaryTreeFromPostorderInorder.TreeNode;

public class D20_BSTfromPreOrder {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}
	private static int id=0;

	public static void main(String[] args) {

		int[] pre = new int[] { 8, 5, 1, 7, 10, 12 };

		System.out.println(BSTrecursive(pre));

	}

	private static TreeNode BSTrecursive(int[] pre) {
		// TODO Auto-generated method stub
		return helper(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);

	}

	private static TreeNode helper(int[] pre, int low, int hi) {
		// TODO Auto-generated method stub
		if (id >= pre.length || pre[id] < low || pre[id] > hi)
			return null;

		int val = pre[id++];
		TreeNode root = new TreeNode(val);
		root.left = helper(pre, low, val);
		root.right = helper(pre, val, hi);

		return root;
	}

}
