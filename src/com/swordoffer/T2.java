package com.swordoffer;

public class T2 {
	public static void main(String[] args) {
		String str = "asdasd asdsad";
		System.out.println(replaceSpace(str));
	}
	
	public static String  replaceSpace(String targerStr) {
		//String targerStr = str.toString();
		StringBuffer sb = new StringBuffer();
		char[] charArray = targerStr.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			
			if(charArray[i] == ' ') {
				sb.append("%20");
			} else {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}
}
