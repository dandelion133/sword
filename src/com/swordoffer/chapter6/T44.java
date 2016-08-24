package com.swordoffer.chapter6;

import java.util.Arrays;

public class T44 {
	public boolean isContinuous(int[] numbers) {
		
		if(numbers == null || numbers.length < 5) return false;
		
		Arrays.sort(numbers);
		
		int numOfZero = 0;
		
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numOfZero ++;
		}
		
		int small = numOfZero;
		int big = small + 1;
		int numOfGap = 0;//¿ÕÈ±×ÜÊý
		
		while(big < numbers.length) {
			
			
			if(numbers[small] == numbers[big]) return false;
			
			numOfGap += numbers[big] - numbers[small] - 1;
			
			small = big;
			big ++;
			
		}
		
		
		return (numOfZero >= numOfGap)?true:false;

	}
	
	
	public static void main(String[] args) {
		T44 t44 = new T44();
		System.out.println(t44.isContinuous(new int[]{0,1,3,4,6}));
		
	}
	
	
}
