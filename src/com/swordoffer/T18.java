package com.swordoffer;

public class T18 {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean rst = false;
		if(root1 != null && root2 != null) {
			if(root1.val == root2.val) {
				rst = doesTree1HaveTree2(root1,root2);
			} 
			if(!rst) {
				rst = HasSubtree(root1.left, root2);
			}
			if(!rst) {
				rst = HasSubtree(root1.right, root2);
			}
		}
		return rst;

	}

	private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 != null) 
			return false;
		else if(root2 == null) {
			return true;
		} 
			
		if(root1.val != root2.val) {
            return false;
        }
		
		return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right, root2.right);
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