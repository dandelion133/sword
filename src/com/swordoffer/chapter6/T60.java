package com.swordoffer.chapter6;

import java.util.ArrayList;
import java.util.Collections;

import com.swordoffer.T23;

public class T60 {

	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(8);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(10);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(7);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(11);
		
		
		
		
		TreeNode node7 = new TreeNode(8);
		TreeNode node8 = new TreeNode(6);
		TreeNode node9 = new TreeNode(10);
		TreeNode node10 = new TreeNode(5);
		TreeNode node11 = new TreeNode(7);
		TreeNode node12 = new TreeNode(9);
		TreeNode node13 = new TreeNode(11);
		TreeNode node16 = new TreeNode(16);
		
		node3.left = node7;
		node3.right = node8;
		
		node4.left = node9;
		node4.right = node10;
		
		node5.left = node11;
		node5.right = node12;
		
		node6.left = node13;
		node6.right = node16;
		
		

		node0.left = node1;
		node0.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.left = node5;
		node2.right = node6;
		
		
		
		
		
		
		
		

		T60 t60 = new T60();
		// ArrayList<Integer> printFromTopToBottom =
		// t23.PrintFromTopToBottom(node0);
		ArrayList<ArrayList<Integer>> print = t60.Print(node0);

		for (ArrayList<Integer> arrayList : print) {
			System.out.print(arrayList + ",");

		}

	}

	public ArrayList<ArrayList<Integer>> Print(TreeNode root) {

		ArrayList<ArrayList<Integer>> rst = new ArrayList<>();
		ArrayList<TreeNode> leftAndRight = new ArrayList<>();
		if (root == null) {
			return rst;
		}
		//boolean reverse = true;
		leftAndRight.add(root);

		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(root.val);
		
		rst.add(values);
		
		while (!leftAndRight.isEmpty()) {

			values = new ArrayList<Integer>();
			ArrayList<TreeNode> temp = new ArrayList<>();
			for (TreeNode node : leftAndRight) {
				
				
					if (node.left != null) {
						values.add(node.left.val);
						temp.add(node.left);
					}
					if (node.right != null) {
						values.add(node.right.val);
						temp.add(node.right);
					}
			}

			leftAndRight = temp;
			if (!leftAndRight.isEmpty()) {
				/*if(reverse)
				Collections.reverse(values);*/
				rst.add(values);
			//	reverse = !reverse;
			}
				

		}
		
		
		
		
		return rst;

	}
}
