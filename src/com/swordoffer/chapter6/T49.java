package com.swordoffer.chapter6;

/**
 * ��+123��Ҫת��Ϊ123������-123��ת��Ϊ-123���ַ������з������硰1a23����û���ַ�������ʱ������0��
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
