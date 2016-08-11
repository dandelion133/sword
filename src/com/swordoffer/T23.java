package com.swordoffer;

import java.util.ArrayList;

public class T23 {
	
	
	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		
		node0.left = node1;
		node0.right = node2;
		
		node1.left = node3;
		node1.right = node4;
		
		node2.left = node5;
		node2.right = node6;
		
		T23 t23 = new T23();
		ArrayList<Integer> printFromTopToBottom = t23.PrintFromTopToBottom(node0);
		
		for (Integer integer : printFromTopToBottom) {
			System.out.print(integer + ",");
		}
		
		
	}
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		
		ArrayList<Integer> rst = new ArrayList<Integer>();
		ArrayList<TreeNode> leftAndRight = new ArrayList<>();
		if(root == null) {
			return rst;
		} 
		
		rst.add(root.val);
		leftAndRight.add(root);
		while(!leftAndRight.isEmpty()) {
			
			
			ArrayList<TreeNode> temp = new ArrayList<>();
			for (TreeNode node : leftAndRight) {
				if(node.left != null) {
					rst.add(node.left.val);
					temp.add(node.left);
				} 
				if(node.right != null) {
					rst.add(node.right.val);
					temp.add(node.right);
				}
				
			}
			
			leftAndRight = temp;
			 
			
			
		}
		return rst;

	}
}
