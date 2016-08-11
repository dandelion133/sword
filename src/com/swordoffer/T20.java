package com.swordoffer;

import java.util.ArrayList;

public class T20 {
	
	
	public static void main(String[] args) {
		//int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1},{2},{3},{4}};
		for (int i = 0; i < matrix.length; i++) {
			
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		T20 t20 = new T20();
		ArrayList<Integer> list = t20.printMatrix(matrix);
		
		for (Integer integer : list) {
			System.out.print(integer + ",");
		}
		
	}
	ArrayList<Integer> rst = null;
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		//ArrayList<Integer> rst = null;
		if (matrix == null) {
			return null;
		} else {
			rst = new ArrayList<Integer>();
			int rows = matrix.length;
			int col = matrix[0].length;
			int start = 0;

			while (col > start * 2 && rows > start * 2) {
				printMatrixIncircle(matrix, col, rows, start);
				start++;
			}
		}

		return rst;
	}

	private void printMatrixIncircle(int[][] matrix, int col,
			int rows, int start) {
		//ArrayList<Integer> rst = new ArrayList<Integer>();

		int endx = col - 1 - start;// 结束的列号
		int endy = rows - 1 - start;// 结束的行号
		System.out.println(endx);
		// 从左到右打印一行
		for (int i = start; i <= endx; i++) {
			//System.out.println(matrix[start][i]);
			rst.add(matrix[start][i]);
		}

		// 从上到下打印一行

		if (start < endy) {
			for (int i = start + 1; i <= endy; i++) {
				//System.out.println(matrix[i][endx]);
				rst.add(matrix[i][endx]);
			}
		}

		// 从右到左打印
		if (start < endy && start < endx) {
			for (int i = endx - 1; i >= start; i--) {
				//System.out.println(matrix[endy][i]);
				rst.add(matrix[endy][i]);
			}
		}

		// 从右到左打印
		if (start < endy - 1 && start < endx) {
			for (int i = endy - 1; i >= start + 1; i--) {
				//System.out.println(matrix[i][start]);
				rst.add(matrix[i][start]);
			}
		}

	}
}
