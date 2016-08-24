package com.swordoffer;

import java.util.HashMap;

public class T38 {
	public int GetNumberOfK(int[] array, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				int value = map.get(array[i]) + 1;
				map.remove(array[i]);
				map.put(array[i], value);
			} else {
				map.put(array[i], 1 );
			}
		}
		
		Integer rst = map.get(k);
		if(rst == null) return 0;
		else return rst;

	}
	
	public static void main(String[] args) {
		T38 t38 = new T38();
		System.out.println(t38.GetNumberOfK(new int[]{1,2,3,3,3,3,4,5},6));
		
	}

}
