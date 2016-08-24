package com.swordoffer.chapter6;

public class T42_1 {
	public String ReverseSentence(String str) {
		
		
		if(str==null||str.trim().equals(""))// trimµô¶àÓà¿Õ¸ñ
	         return str;
		
		
		String[] split = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = split.length - 1; i >= 0 ; i --) {
			sb.append(split[i]);
			if(i != 0) 
				sb.append(" ");
		}
		
		
		return sb.toString();

	}
	
	
	public static void main(String[] args) {
		T42_1 t42_1 = new T42_1();
		System.out.println(t42_1.ReverseSentence("I am a student."));
		
	}
	
	
	
}
