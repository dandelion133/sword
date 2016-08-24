package com.swordoffer;

import java.util.ArrayList;

public class T25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	
    	if(root == null) {
    		return rst;
    	}
    	
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	
    	int currentSum = 0;
    	
    	findPath(root, target, rst, path, currentSum);
    	
		return rst;
        
    }
    
    
    void findPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> rst,ArrayList<Integer> path,int currentSum) {
    	
    	currentSum += root.val;
    	path.add(root.val);
    	boolean isLeaf = root.left == null && root.right == null;
    	
    	if(currentSum == target && isLeaf) {
    		ArrayList<Integer> temp = new ArrayList<Integer>(path);

    		rst.add(temp);
    	}
    	
    	if(root.left != null) {
    		findPath(root.left, target, rst, path, currentSum);
    		
    	}
    	if(root.right != null) {
    		findPath(root.right, target, rst, path, currentSum);
    	}
    	
    	path.remove(path.size() - 1);
    	currentSum -= root.val;
    	
    }
    
}
