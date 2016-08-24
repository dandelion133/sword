package com.swordoffer.chapter6;

import java.util.HashMap;
import java.util.Iterator;

public class T40 {
	
	private HashMap hashMap = null;
	
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		hashMap = map;
		int[] rst = new int[2];
		for (int i = 0; i < array.length; i++) {
			if(map.containsKey(array[i])) {
				int value = map.get(array[i]);
				map.remove(array[i]);
				map.put(array[i], value + 1);
				
			} else {
				map.put(array[i], 1);
			}
		}
		
		Iterator<Integer> iterator = map.keySet().iterator();
		int j = 0;
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			int v = map.get(key);
			if(v == 1) 
				rst[j ++] = key;
			
		}
		
		num1[0] = rst[0];
		num2[0] = rst[1];
		
	}
	/**
	 * asdasdasdasdasd
	 * @author QHF
	 *
	 */
	interface AnInterface {
		int CONTANT = 2;
		int method();
		String str= "adasdasdasd";
	}
	
}
