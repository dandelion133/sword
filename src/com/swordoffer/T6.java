package com.swordoffer;

public class T6 {
	 public static int minNumberInRotateArray(int [] array) {
		int min = 0;
		 for (int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				min = array[i + 1];
				break;
			}
		}
		return min;
		    
	    }
	 
	 public static void main(String[] args) {
		int[] array = new int[]{3,4,5,6,2};
		System.out.println(minNumberInRotateArray(array));
	}
}
