package com.swordoffer;

import java.util.Arrays;

public class T29 {
	public int MoreThanHalfNum_Solution(int[] array) {
		
		if(array.length == 0 || array == null) return 0;
		
		Arrays.sort(array);
		
		int mid = array[array.length >> 1];
		int j = 0;
		for (int i : array) {
			if(i == mid) 
				j ++; 
		}
		if(j > array.length >> 1) return  mid;
		
		return 0;

	}
}
