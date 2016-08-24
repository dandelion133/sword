package com.swordoffer.chapter6;

public class T47 {
	public int Add(int num1, int num2) {
		
		int sum = 0;
		int carry = (num1 & num2) << 1;
		while(num2 != 0) {
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}
		
		
		
		
		return num1;

	}
	
	public static void main(String[] args) {
		T47 t47 = new T47();
		System.out.println(t47.Add(40, 30));
		
	}
}
