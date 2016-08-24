package com.swordoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author QHF
 *
 */
public class T33 {
	public String PrintMinNumber(int[] numbers) {

		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			numList.add(numbers[i]);
		}

		Collections.sort(numList, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1 +""+ o2;
				String str2 = o2 +""+ o1;
				return str1.compareTo(str2);
				
			}
		});
		String rst = "";
		for (Integer integer : numList) {
			rst += integer;
		}
		
		
		return rst;

	}
	
	public static void main(String[] args) {
		T33 t33 = new T33();
		System.out.println(t33.PrintMinNumber(new int[]{3,32,321}));
		
	}
	
}
