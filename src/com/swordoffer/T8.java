package com.swordoffer;

import java.util.ArrayList;
import java.util.Scanner;

public class T8 {
	public void reOrderArray(int[] array) {
		ArrayList<Integer> odds = new ArrayList<Integer>();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		
		for (int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0) {
				evens.add(new Integer(array[i]));
			} else {
				odds.add(new Integer(array[i]));
			}
		}
		
		for (int i = 0; i < odds.size(); i++) {
			array[i] = odds.get(i);
		}
		for (int i = 0; i < evens.size(); i++) {
			array[odds.size() + i] = evens.get(i);
		}
		
	}
	
	
	public static void main(String[] args) {
		T8 t8 = new T8();
		
		int[] array = new int[]{1,2,3,4,5,6,7,8};
		t8.reOrderArray(array );
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
