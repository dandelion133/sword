package com.swordoffer.chapter6;

/**
 * “+123”要转化为123，而“-123”转化为-123，字符串中有非数字如“1a23”和没有字符串输入时都返回0。
 * 
 * @author QHF
 *
 */
public class T49 {
	public int StrToInt(String str) {
		
		if(str.isEmpty()) return 0;
		
		char[] chars = str.toCharArray();
		int sign = 1;
		int sum = 0;
		if(chars[0] == '-') {
			sign = -1;
		} else if(chars[0] == '+') {
			sign = 1;
		} else if(chars[0] < '0' || chars[0] > '9') {
			return 0;
		} else {
			sum = (chars[0] - '0') * (int)Math.pow(10, str.length() - 1);
		}
		
		
		for (int i = 1; i < chars.length; i++) {
			if(chars[i] < '0' || chars[i] > '9') {
				return 0;
			}
		//	System.out.println(sum);
			sum += (chars[i] - '0') * (int)Math.pow(10, str.length() - i - 1);
		}
		
	//	System.out.println(sum);
	//	System.out.println(sign);
		
		return sum * sign;

	}
	
	public static void main(String[] args) {
		T49 t49 = new T49();
		System.out.println(t49.StrToInt("1a56"));
		
	}
	
	
}
