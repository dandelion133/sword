package com.swordoffer.chapter6;

public class T39 {

	private int maxDepth = 0;

	public int TreeDepth(TreeNode pRoot) {

		if (pRoot == null)
			return 0;
		maxDepth = 0;
		dfs(pRoot, 1);

		return maxDepth;

	}

	public void dfs(TreeNode pRoot, int depth) {
		if (pRoot == null) {
			return;
		}

		if (depth > maxDepth) {
			maxDepth = depth;
		}

		dfs(pRoot.left, depth + 1);
		dfs(pRoot.right, depth + 1);

	}

	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) {
			return true;
		}
		
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		
		int dif = left - right;
		if(dif > 1 || dif < -1) {
			return false;
		}
		boolean isLeft = IsBalanced_Solution(root.left);
		boolean isRight = IsBalanced_Solution(root.right);
		
		
		return isLeft && isRight;

	}

	public static void main(String[] args) {
		T39 t39 = new T39();

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;

		node2.left = node4;
		node2.right = node5;

		node3.right = node6;

		node5.left = node7;

		node6.left = node8;
		node8.left = node9;
		node9.right = node10;

		System.out.println(t39.TreeDepth(node1));

	}

}
