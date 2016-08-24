package com.swordoffer.chapter6;

public class T66 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		if (matrix.length != rows * cols)
			return false;

		boolean[] hasVisited = new boolean[rows * cols];
		int strIndex = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (hasPathCore(matrix, rows, cols, row, col, str, strIndex,hasVisited))
					return true;
			}
		}
		return false;

	}

	public boolean hasPathCore(char[] matrix, int rows, int cols, int row,
			int col, char[] str, int strIndex, boolean[] hasVisited) {
		
		int index = row * cols + col;
		System.out.println(index);
		if (col < 0
		|| col >= cols
		|| row < 0
		|| row >= rows
		|| index >= cols * rows
		|| matrix[index] != str[strIndex]
		|| hasVisited[index])
			return false;

		if (str.length - 1 == strIndex) //递归函数的出口
			return true;
		
		hasVisited[index] = true;
		if (hasPathCore(matrix, rows, cols, row - 1, col, str, strIndex + 1,hasVisited)
				|| hasPathCore(matrix, rows, cols, row, col - 1, str,strIndex + 1, hasVisited)
				|| hasPathCore(matrix, rows, cols, row + 1, col, str,strIndex + 1, hasVisited)
				|| hasPathCore(matrix, rows, cols, row, col + 1, str,strIndex + 1, hasVisited)) {

			return true;

		}

		hasVisited[index] = false;// 回溯需要清除标志位
		return false;

	}

	public static void main(String[] args) {
		T66 t66 = new T66();
		System.out.println(t66.hasPath("ABCD".toCharArray(), 2, 2,"AC".toCharArray()));

	}

}
