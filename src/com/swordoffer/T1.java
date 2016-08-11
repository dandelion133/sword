package com.swordoffer;

public class T1 {
	public static void main(String[] args) {
		
		
		int a[][]=new int[3][3];
		
		//System.out.println(a.length);
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (i + 1) * (j + 1);
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]+","); 
			}
			System.out.println();
		}
		System.out.println(find(a,6));
		
	}
	
	public static boolean find(int [][] array,int target) {
		//int row = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println(array[i][j] + "," + target);
				if(array[i][j] == target) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
}
