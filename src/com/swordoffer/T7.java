package com.swordoffer;

public class T7 {
	public double Power(double base, int exponent) {
		double s = 1;
		if(exponent == 0) {
			return 1;
		} else if(exponent < 0) {
			exponent = 0 - exponent;
			while(exponent != 0) {
				s *= base;
				exponent --;
			}
			//System.out.println("s:"+s);
			s = 1/s;
		}  else {
			while(exponent != 0) {
				s *= base;
				exponent --;
			}
		}
		return s;
	}
	public static void main(String[] args) {
		T7 t7 = new T7();
		System.out.println(t7.Power(1.7, -2));
		
	}
	
	
	
}
