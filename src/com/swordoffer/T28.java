package com.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
//在自己这层循环   step一直不变   实现切换递归
public class T28 {
	private char[] seqs;
	private  boolean[] isVisted;
	// 用于结果去重
	private HashSet<String> result = new HashSet<String>();

	/**
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。 例如输入字符串abc,则打印出由字符a,b,c
	 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。
	 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。\
	 * 
	 * @param str
	 * @return
	 */
	public ArrayList<String> Permutation(String str) {
		
		ArrayList<String> rst = new ArrayList<String>();
		if(str == null || str.isEmpty()) return rst;
		
		char[] chars = str.toCharArray();
		isVisted = new boolean[chars.length];
		seqs = new char[chars.length];
		dfs(chars,0);
		
		rst.addAll(result);
		Collections.sort(rst);
		return rst;
		
	}

	/**
	 * 深度遍历法
	 */
	private void dfs(char[] chars, int step) {
		
		if(chars.length == step) {
		//	StringBuilder sb = new StringBuilder();
			String str = "";
			for (int i = 0; i < seqs.length; i++) {
				str += seqs[i];
				//sb.append(seqs[i]);
			}
			
			result.add(str);
			return;
			
		} 
		
		for (int i = 0; i < chars.length; i++) {
			
			if(!isVisted[i]) {
				seqs[step] = chars[i];
				isVisted[i] = true;
				dfs(chars,step + 1);
				isVisted[i] = false;
			}
			
		}
		
	}

	public static void main(String[] args) {
		T28 t28 = new T28();

		ArrayList<String> permutation = t28.Permutation("qwe");

		for (String string : permutation) {
			System.out.print(string + ",");
		}
	}

}
