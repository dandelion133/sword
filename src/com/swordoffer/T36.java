package com.swordoffer;
/**
 * �����е������
 * 
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P������P��1000000007ȡģ�Ľ������� 
 * �����P%1000000007 
 * @author QHF
 *
 */
public class T36 {
	public int InversePairs(int[] array) {

		if (array == null || array.length == 0)
			return 0;
		int[] copy = new int[array.length];

		for (int i = 0; i < copy.length; i++) {
			copy[i] = array[i];// ���
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
		// i ��ʼ��Ϊǰ������һ�����ֵ��±�
		int i = start + length;
		//int i = mid;
		// j ��ʼ��Ϊǰ�������һ�����ֵ��±�
		int j = end;

		// �൱�ڸ������� ����copy������
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
