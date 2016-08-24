package com.swordoffer;

public class T31 {
	public int FindGreatestSumOfSubArray(int[] array) {
		
		if(array.length == 0 || array == null) return 0;
		
		int sum = 0;
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < array.length; i++) {
			if(sum <= 0) {
				sum = array[i];				
			} else {
				sum += array[i];
			}
			
			if(sum > max) {
				max = sum;
			}
		}
		return max;

	}
	
	
	
	public static void main(String[] args) {
		/*System.out.println(0x70000000);
		Integer.MAX_VALUE;*/
		
		
		T31 t31 = new T31();
		System.out.println(t31.FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
		
	}
}
