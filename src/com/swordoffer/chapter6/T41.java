package com.swordoffer.chapter6;

import java.util.ArrayList;

public class T41 {
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		
		int small = 1;
		int big = 2;
		
		int mid = (1 + sum) >> 1;
		
		int curSum = small + big;
		//System.out.println("mid: " + mid);
		
		while(small < mid) {
			if(curSum == sum) {
				
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				int i = small;
			//	System.out.println("small: " + small);
				while(i <= big) {
					
					list.add(i);
					i ++;
				//	System.out.println("add: " + i);
				}
				rst.add(list);
			//	System.out.println(list);
				//±£´æ
			}
			
			while(curSum > sum && small < mid) {
				curSum -= small;
				small ++;
				//System.out.println(small + "small ++ ");
				if(curSum == sum) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					int i = small;
					while(i <= big) {
						
						list.add(i);
						i ++;
					}
					rst.add(list);
				}
				
			}
			
			big ++;
			curSum += big;
			//System.out.println("µ±Ç°curSum£º " + curSum + ",big: " + big);
			
		}
		
		return rst;

	}
	
	
	
	public static void main(String[] args) {
		T41 t41 = new T41();
		ArrayList<ArrayList<Integer>> findContinuousSequence = t41.FindContinuousSequence(21);
		for (int i = 0; i < findContinuousSequence.size(); i++) {
			System.out.print(findContinuousSequence.get(i));
			int s = 1;
			for (int j = 0; j < findContinuousSequence.get(i).size(); j++) {
				s *= findContinuousSequence.get(i).get(j);
			}
			System.out.println(s);
			
		}
		
	}
}
