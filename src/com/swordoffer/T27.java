package com.swordoffer;

public class T27 {

	TreeNode head = null;
	TreeNode realHead = null;
	
	public TreeNode Convert(TreeNode pRootOfTree) {
		
		
		convert(pRootOfTree);
		
		
		return realHead;

	}

	private void convert(TreeNode pRootOfTree) {
		
		if(pRootOfTree == null) return;
		convert(pRootOfTree.left);
		
		if(head == null) {
			head = pRootOfTree;
			realHead = pRootOfTree;
		} else {
			head.right = pRootOfTree;
			pRootOfTree.left = head;
			head = pRootOfTree;
		}
		convert(pRootOfTree.right);
		
	}

	private class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
}
