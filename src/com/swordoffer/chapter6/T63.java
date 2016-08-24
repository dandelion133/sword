package com.swordoffer.chapter6;

import java.util.Stack;

public class T63 {
	//int k;
	int count = 0;
    TreeNode KthNode(TreeNode pRoot, int k) {
    	if(count > k || pRoot == null) return null;
    	
    	TreeNode  p = pRoot;
    	TreeNode  rst = null;
    	Stack<TreeNode> nodes = new Stack<TreeNode>();
    	
    	while(p != null || !nodes.isEmpty()) {
    		while(p != null) {
    			nodes.push(p);
    			p = p.left;
    		}
    		TreeNode node = nodes.pop();
    		System.out.println(node);
    		count ++;
    		if(count == k) {
    			rst = node;
    		}
    		p = node.right;
    		
    		
    	}
		return rst;
    	
    	
    	
    	
    	
	}
	
	
	/*TreeNode KthNodeCore(TreeNode pRoot) {
		
		TreeNode target = null;
		if(pRoot.left != null) {
			target = KthNodeCore(pRoot.left);
			System.out.println("----" + target == null );
		}
			
		if(target == null) {
			if(k == 1)
				target = pRoot;
			
			k --;
			System.out.println(k);
		}
		
		
		if(target == null && pRoot.right != null) 
			target = KthNodeCore(pRoot.right);
		
		
		return pRoot;

	}
	*/
	
	public static void main(String[] args) {
		T63 t63 = new T63();
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node5.left = node3;
		node5.right = node7;
		
		node3.left = node2;
		node3.right = node4;
		
		
		node7.left = node6;
		node7.right = node8;
		
		
		System.out.println(t63.KthNode(node5, 6) + "½á¹û");
		
	}
	
}
