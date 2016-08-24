package com.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class T30 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		
		ArrayList<Integer> rst = new ArrayList<Integer>();
		
		if(input.length == 0 || input == null || input.length < k) {
			return rst;
		}
		
		Arrays.sort(input);
		
		for (int i = 0; i < k; i++) {
			rst.add(input[i]);
		}
		
		
		
		return rst;

	}
}
