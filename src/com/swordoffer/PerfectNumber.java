package com.swordoffer;

import java.util.ArrayList;

public class PerfectNumber {
	public static int perfectNUmberCheck(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < n; i++) {
			if(n % i == 0) {
				list.add(i);
			}
		}
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		if(sum == n) {
			return  1;
		} else
		return 0;
	}
	
	public static void main(String[] args) {
		int x = perfectNUmberCheck(28);
		System.out.println(x);
	}
}
