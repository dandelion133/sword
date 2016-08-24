package com.swordoffer.chapter6;

public class T42_2 {
	public String LeftRotateString(String str, int n) {
		
		
		if(str.isEmpty() ) return "";
		
		String begin = str.substring(0, n);
		String end = str.substring(n, str.length());
		
		
		
		return end + begin;

	}
	
	
	public static void main(String[] args) {
		T42_2 t42_2 = new T42_2();
		System.out.println(t42_2.LeftRotateString("abcdefg", 3));
		
	}
	
}
