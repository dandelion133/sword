package com.swordoffer.chapter6;

import java.util.ArrayList;

public class T45 {
	public int LastRemaining_Solution(int n, int m) {
		
		if(n < 1 || m < 1) return -1;
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			data.add(i);
		}
		
		int index = 0;
		
		while(data.size() > 1) {
			index = (index + m - 1) % data.size();
			data.remove(index);
		}
		
		
		
		return data.get(0);

	}
}
