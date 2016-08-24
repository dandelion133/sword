package com.swordoffer;
/**
 * 数组中的逆序对
 * 
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 
 * 即输出P%1000000007 
 * @author QHF
 *
 */
public class T36 {
	public int InversePairs(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int[] copy = new int[array.length];

		for (int i = 0; i < copy.length; i++) {
			copy[i] = array[i];// 深复制
		}

		int count = inversePairsCore(array, copy, 0, array.length - 1);

		return count;

	}

	public int inversePairsCore(int[] data, int[] copy, int start, int end) {

		if (start == end) {
		//	copy[start] = data[start];
			return 0;
		}
		int length = (end - start) >> 1;
		//int mid = (end + start) >> 1;
		int left = inversePairsCore(copy, data, start, start + length) % 1000000007;
		int right = inversePairsCore(copy, data, start + length + 1, end) % 1000000007;
		/*int left = inversePairsCore(data, copy, start, mid) % 1000000007;
		int right = inversePairsCore(data, copy, mid + 1, end) % 1000000007;*/
		// i 初始化为前半段最后一个数字的下标
		int i = start + length;
		//int i = mid;
		// j 初始化为前后半段最后一个数字的下标
		int j = end;

		// 相当于辅助数组 存在copy数组中
		int indexCopy = end;

		int count = 0;

		while (i >= start && j >= start + length + 1) {
			if (data[i] > data[j]) {
				copy[indexCopy--] = data[i--];
				count += j - start - length;
				if (count >= 1000000007) {
					count %= 1000000007;
				}

			} else {
				copy[indexCopy--] = data[j--];
			}
		}

		for (; i >= start; i--) {
			copy[indexCopy--] = data[i];
		}

		for (; j >= start + length + 1; j--) {
			copy[indexCopy--] = data[j];
		}

		return (left + right + count) % 1000000007;
	}

	public static void main(String[] args) {
		T36 t36 = new T36();
		System.out.println(t36.InversePairs(new int[] {1,2,3,4,5,6,7,0 }));
		System.out.println(1493330284 % 1000000007);

	}

}
