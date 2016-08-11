package com.swordoffer;

import java.util.ArrayList;

public class WordListOrder {
	public static int canArrangeWords(String arr[]) {
		
		//找起点单词 终点单词
		//开始搜索
		ArrayList<String> list = new ArrayList<String>(); 
		/*for (String string : arr) {
			
			list.add(string);
		}*/
		
		for (int i = 0; i < arr.length;i++) {
			list.clear();
			for (String string : arr) {
				list.add(string);
			}
			char[] charArray = list.get(i).toCharArray();
			int l = charArray.length;
			char c = charArray[l - 1];
			System.out.println(list.get(i));
			for(int j = 0; j < i; j ++)
				list.remove(list.get(j));
			System.out.println("i: "+i);
			System.out.println("list: " + list);
			list.remove(list.get(i));
			
			
			
			
			System.out.println(c);
			System.out.println(list);
			if(fuction(c,list)) {
				return 1;
				
			}
			
		}
		return -1;
	}
	
	private static boolean fuction(char c , ArrayList<String> list) {
		
		if(list.size() == 1) {
			char[] charArray3 = list.get(0).toCharArray();
			if(charArray3[charArray3.length - 1] == c) {
				return true;
			} else {
				return false;
			}
		}
		for(int i = 0 ; i < list.size() ; i ++) {
			char[] charArray = list.get(i).toCharArray();
			if(c == charArray[0]) {
				list.remove(list.get(i));
				char[] charArray2 = list.get(0).toCharArray();
				fuction(charArray2[charArray2.length-1],list);
				
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		System.out.println(canArrangeWords(new String[]{"ass","ssd","def","frg"}));
	}
	
}
