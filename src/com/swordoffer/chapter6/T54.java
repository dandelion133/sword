package com.swordoffer.chapter6;
/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author QHF
 *
 */
public class T54 {
	public boolean isNumeric(char[] str) {
		
		if(str.length == 0) return false;
		if(str.length == 1 && str[0] < '0' && str[0] > '9') return false;
		if(str[0] == '+' || str[0] == '-') {
			if(str.length == 2 && str[1] == '.') 
				return false;
		} else if(str[0] < '0' && str[0] > '9' &&  str[0] !=  '.')
			return false;
		
		
		int i = 1;
		//扫描字符串数字
		while(i < str.length && str[i] >= '0' && str[i] <= '9') {
			i ++;
		}
		
		if(i < str.length && str[i] == '.') {//小数
			i ++;
			//扫描字符串数字
			while(i < str.length && str[i] >= '0' && str[i] <= '9') {
				i ++;
			}
			
		}
		
		if(i < str.length && (str[i] == 'e' || str[i] == 'E')) {//指数
			i ++;
			if(i < str.length && (str[i] == '+' || str[i] == '-')) {//指数
				i ++;
			}
			if(i < str.length) {
				//扫描字符串数字
				while(i < str.length && str[i] >= '0' && str[i] <= '9') {
					i ++;
				}
			} else {
				return false;
			}
		}
		
		if(i < str.length) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		T54 t54 = new T54();
		System.out.println(t54.isNumeric("123.45e+6".toCharArray()));
		
	}
	
	
}
