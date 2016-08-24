package com.swordoffer.chapter6;

public class T46 {

	public int Sum_Solution(int n) {
		int sum = n;
		boolean ans = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
		return sum;
	}
	
	public static void main(String[] args) {
		T46 t46 = new T46();
		System.out.println(t46.Sum_Solution(3));
		
	}
}
