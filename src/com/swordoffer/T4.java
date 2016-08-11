package com.swordoffer;

public class T4 {
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		reConstructBinaryTree(pre, in);
		
		
		System.out.println(reConstructBinaryTree(pre, in).val);
	}
	
	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reBuildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		
		return root;

	}
	
	private static TreeNode reBuildBinaryTree(int[] pre,int startPre,int endPre, int[] in,int startIn,int endIn) {
		
		if(startPre > endPre || startIn > endIn) {
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);
		
		for (int i = startIn; i <= endIn; i++) {
			if(root.val == in[i]) {
				root.left = reBuildBinaryTree(pre, startPre + 1,startPre +  i - startIn , in, startIn, i - 1);
				root.right = reBuildBinaryTree(pre, startPre +  i - startIn + 1, endPre, in, i + 1, endIn);
				break;
			}
		}
		
		return root;

		
	}
	
	
	
	
	
}

