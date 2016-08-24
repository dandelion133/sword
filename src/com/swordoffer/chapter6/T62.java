package com.swordoffer.chapter6;

public class T62 {
	String Serialize(TreeNode root) {
		StringBuffer sb = new StringBuffer();
		if(root == null) {
			sb.append("$,");
			return sb.toString();
		}
		
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		
		
		
		return sb.toString();

	}
	private int index = -1;
	TreeNode Deserialize(String str) {
		index ++;
		int len = str.length();
		if(index >= len) {
			return null;
		}
		
		String[] cs = str.split(",");
		
		TreeNode node = null;
		if(!cs[index].equals("$")) {
			node = new TreeNode(Integer.valueOf(cs[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;

	}
}
