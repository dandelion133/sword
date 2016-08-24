package com.swordoffer.chapter6;

import java.util.ArrayList;
/**
 * h和为s的两个数
 * @author QHF
 *
 */
public class T41_2 {

	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		
		ArrayList<Integer> rst = new ArrayList<Integer>();
		
		if(array.length == 0 || array == null) return rst;
			
		
		int ahead = array.length - 1;
		int behind = 0;
		long mul = Long.MAX_VALUE;
		while(ahead > behind) {
			long curSum = array[ahead] + array[behind];
			
			if(curSum == sum) {
				int tmp = array[ahead] * array[behind];
				if( tmp < mul) {
					rst.add(array[behind]);
					rst.add(array[ahead]);
					
					mul = tmp;
				}
				behind ++;
				
			} else if(curSum > sum) {
				ahead --;
			} else {
				behind ++;
			}
		}
		
		return rst;

	}
	public static void main(String[] args) {
		T41_2 t41_2 = new T41_2();
		
		ArrayList<Integer> sum = t41_2.FindNumbersWithSum(new int[]{1,2,3,4,5,6,7}, 8);
		
		System.out.println(sum);
		
		
	}

}
