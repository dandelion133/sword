package com.swordoffer.chapter6;



public class TreeLinkNode {
	int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return val + "";
    }
}
