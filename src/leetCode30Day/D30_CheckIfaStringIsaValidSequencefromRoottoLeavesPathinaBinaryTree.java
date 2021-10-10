package leetCode30Day;

public class D30_CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode x = new TreeNode(0);
		x.left = new TreeNode(1);
		x.right = new TreeNode(0);
		x.left.left = new TreeNode(0);
		x.left.right = new TreeNode(1);

		// x.left= new TreeNode(1);
		x.right.left = new TreeNode(0);
		x.left.left.right = new TreeNode(1);
		x.left.right.left = new TreeNode(0);
		x.left.right.right = new TreeNode(0);
		int arr[] = new int[] { 0, 0, 1 };

		System.out.println(helper(x, arr, 0));

	}

	public static boolean helper(TreeNode root, int[] arr, int i) {

		if (root == null)
			return false;

		else if (i >= arr.length - 1 && (root.left != null || root.right != null)) {
			// System.out.println("yu");
			return false;
		}

		else if (i == arr.length - 1 && root.left == null && root.right == null) {
			// System.out.println("yu");
			if (root.val == arr[i])
				return true;
			else
				return false;
		}

		else if (root.val != arr[i])
			return false;
		else {
			i += 1;
			boolean left = helper(root.left, arr, i);
			boolean right = helper(root.right, arr, i);
			return left || right;
		}
	}

}
