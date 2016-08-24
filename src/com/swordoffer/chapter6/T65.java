package com.swordoffer.chapter6;

import java.util.ArrayList;

public class T65 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> rst = new ArrayList<Integer>();
		if(num.length < size || size == 0) {
			return rst;
		}
		
		for (int i = 0; i <= num.length - size; i++) {
			int max = num[i];
			for (int j = i + 1; j < size + i; j++) {
				if(num[j] > max) {
					max = num[j];
				}
			}
			
			rst.add(max);
			
		}
		
		
		return rst;

	}
}
