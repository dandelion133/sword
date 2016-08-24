package com.swordoffer;

import java.util.Arrays;

public class T24 {
	
	
	public static void main(String[] args) {
		T24 t24 = new T24();
		boolean verifySquenceOfBST = t24.VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10});
		System.out.println(verifySquenceOfBST);
		
		
		
		int[] a = new int[]{4,8,6,12,16,14,10};
		
		int[] copyOfRange = Arrays.copyOfRange(a, 4, 7);
		for (int i : copyOfRange) {
			
			System.out.print(i + ",");
		}
		
	}
	
	
	public boolean VerifySquenceOfBST(int[] sequence) {

		if (sequence == null || sequence.length == 0)
			return false;
		int len = sequence.length;

		// �ڶ����������ֶ���������
		int i = 0;// ��������λ��
		for (; i < len - 1; i++) {
			if (sequence[i] > sequence[len - 1])
				break;
		}
		int j = i;
		for (; j < len - 1; j++) {
			if (sequence[j] < sequence[len - 1])
				return false;
		}
		// �ж��������ǲ���
		boolean left = true;

		if (i > 0) {
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		}
		// �ж��������ǲ���
		boolean right = true;

		if (i < len - 1) {
			right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, len - 1));
		}

		return (left && right);

	}
}
