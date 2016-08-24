package com.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
//���Լ����ѭ��   stepһֱ����   ʵ���л��ݹ�
public class T28 {
	private char[] seqs;
	private  boolean[] isVisted;
	// ���ڽ��ȥ��
	private HashSet<String> result = new HashSet<String>();

	/**
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С� ���������ַ���abc,���ӡ�����ַ�a,b,c
	 * �������г����������ַ���abc,acb,bac,bca,cab��cba�� ����밴��ĸ˳�������
	 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��\
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
	 * ��ȱ�����
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
