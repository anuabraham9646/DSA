package leetcodeMay30Day;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

	Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

	We are given the root of a binary tree with unique values, and the values x and y of two different nodes
	in the tree.	Return true if and only if the nodes corresponding to the values x and y are cousins.
 * 
 * 
 */

public class CousinsInBinaryTree {
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
	static int xDepth;
	static int yDepth;
	static int xPar;
	static int yPar;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(3);
		root.left.right=new TreeNode(4);
		root.right.right=new TreeNode(5);
		System.out.println(helper(root,5,4,null,0));
		
		System.out.println(helperBFS(root,2,3));

	}

	private static boolean helperBFS(TreeNode root, int a, int b) {

		Queue<TreeNode>q= new LinkedList<>();
		q.add(root);
		TreeNode x;
		while(!q.isEmpty()) {
			boolean bExist= false;
			boolean aExist= false;
			int n= q.size();
			for(int i=0;i< n;i++) {
				x= q.remove();
				
				if(x.left!= null && x.right!= null) {
					if(x.left.val ==a && x.right.val==b)
						return false;
					if(x.left.val ==b && x.right.val==a)
						return false;
				}
				if(x.left!=null) {
					if(x.left.val == a)
						aExist= true;
					if(x.left.val == b)
						bExist= true;
					q.add(x.left);
				}
				
				if(x.right!=null) {
					if(x.right.val == a)
						aExist= true;
					if(x.right.val == b)
						bExist= true;
					q.add(x.right);
				}
				if(aExist && bExist)
					return true;
			}
		}
		
		return false;
	}

	private static boolean helper(TreeNode root, int x, int y, TreeNode parent, int depth) {
		// TODO Auto-generated method stub
		if(root== null)
			return false;
		if(root.val==x) {
			xDepth= depth;
			xPar= parent.val;
			return true;
			
		}
		if(root.val==y) {
			yDepth= depth;
			yPar= parent.val;
			return true;
		}


		boolean lft= helper(root.left,x,y,root,depth+1);
		boolean rt= helper(root.right,x,y,root,depth+1);
		
		if(! lft&&rt)
			return false;
		
		return xDepth==yDepth && xPar!=yPar;
	}

}
