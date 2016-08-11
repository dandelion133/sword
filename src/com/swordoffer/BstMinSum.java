package com.swordoffer;

import java.util.LinkedList;

public class BstMinSum {
	
	
	public static void main(String[] args) {
		TNode node14 = new TNode(3,null,null);
		TNode node13 = new TNode(9,null,null);
		TNode node12 = new TNode(2,null,null);
		TNode node11 = new TNode(5,null,null);
		TNode node10 = new TNode(3,null,null);
		TNode node9 = new TNode(9,null,null);
		TNode node8 = new TNode(2,null,null);
		TNode node7 = new TNode(5,null,null);
		TNode node6 = new TNode(3,node13,node14);
		TNode node5 = new TNode(9,node11,node12);
		TNode node4 = new TNode(2,node9,node10);
		TNode node3 = new TNode(5,node7,node8);
		TNode node2 = new TNode(2,node5,node6);
		TNode node1 = new TNode(1,node3,node4);
		TNode root = new TNode(10,node1,node2);
		int v = minTreePath(root);
		System.out.println(v);
	}
	
	
	public static int minTreePath(TNode root) {
	    if (root == null) {
	        return 0;
	    } else if (root.left != null && root.right != null) {
	        return 1+Math.min(minDepth(root.left), minDepth(root.right));
	    } else {
	        return 1+Math.max(minDepth(root.left), minDepth(root.right));
	    }
	}
	
	
	
	public static int minDepth(TNode root) {
	    if (root == null) {
	        return 0;
	    }
	    LinkedList<TNode> queue = new LinkedList<>();
	    queue.add(root);
	    int depth = 1;
	    while (!queue.isEmpty()) {
	        int l = queue.size();
	        int vLeft = 0;
	        int vRight = 0;
	        for (int i = 0; i < l; i++) {
	        	
	            TNode n = queue.poll();
	            if (n.left == null && n.right == null) {
	            	System.out.println(n.value);
	            	return depth;
	            } 
	            if (n.left != null) {
	                queue.add(n.left);
	                vLeft += n.left.value;
	            }
	            if (n.right != null) {
	                queue.add(n.right);
	                vRight += n.right.value;
	            }
	        }
	        depth++;
	    }
	    System.out.println("return "+depth);
	    return depth;
	}
}