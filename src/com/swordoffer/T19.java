package com.swordoffer;

public class T19 {
	//µÝ¹é
	public void Mirror(TreeNode root) {
		if(root == null) {
			return;
		} else if(root.left == null && root.right == null) {
			return;
		}
		//¿ªÊ¼½»»»Ë³Ðò
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		if(root.left != null)
			Mirror(root.left);
		if(root.right != null) {
			Mirror(root.right);
		}
		
		
	}

	class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

}