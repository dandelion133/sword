package com.swordoffer.chapter6;

public class T67 {
	public int movingCount(int threshold, int rows, int cols) {

		boolean[] hasVisited = new boolean[rows * cols];

		int count = movingCount(threshold, rows, cols, 0, 0, hasVisited);

		return count;

	}

	public int movingCount(int threshold, int rows, int cols, int row, int col,boolean[] hasVisited) {

		int index = row * cols + col;
		int count = 0;
		
		if (col < 0 || col >= cols || row < 0 || row >= rows
				|| index >= cols * rows || hasVisited[index]
				|| getDigitSum(row) + getDigitSum(col) > threshold) {
			return 0;
		}

		hasVisited[index] = true;
		count = 1
				+ movingCount(threshold, rows, cols, row - 1, col, hasVisited)
				+ movingCount(threshold, rows, cols, row, col - 1, hasVisited)
				+ movingCount(threshold, rows, cols, row + 1, col, hasVisited)
				+ movingCount(threshold, rows, cols, row, col + 1, hasVisited);

		// hasVisited[index] = false;// 回溯需要清除标志位
		return count;

	}

	public int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;

	}
	public static void main(String[] args) {
		T67 t67 = new T67();
		System.out.println(t67.movingCount(5, 10, 10));
		
	}

}
