package com.swordoffer.chapter6;

/**
 * ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ�� 1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ� 2�����
 * �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��
 * 
 * ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
 * ����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
 * 1��ģʽ����2�ַ����൱��x*�����ԣ� 2���ַ�������1�ַ���ģʽ����2�ַ��� 3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
 * 
 * @author QHF
 *
 */
public class T53 {
	public boolean match(char[] str, char[] pattern) {

		if (str == null || pattern == null)
			return false;

		int strIndex = 0;
		int patternIndex = 0;

		return matchCore(str, strIndex, pattern, patternIndex);

	}

	public boolean matchCore(char[] str, int strIndex, char[] pattern,
			int patternIndex) {
		// System.out.println("/////");
		if (str.length == strIndex && patternIndex == pattern.length)
			return true;

		if (str.length != strIndex && patternIndex == pattern.length)
			return false;

		// �ڶ����ַ���'*'
		if (patternIndex + 1 < pattern.length
				&& pattern[patternIndex + 1] == '*') {
			// ��һ��ƥ��ɹ� ���������

			if (strIndex != str.length
					&& (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
				// System.out.println("...");

				return matchCore(str, strIndex, pattern, patternIndex + 2)// ģʽ����2�ַ����൱��x*�����ԣ�
						|| matchCore(str, strIndex + 1, pattern,
								patternIndex + 2)// �ַ�������1�ַ���ģʽ����2�ַ���
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// *ƥ��1������ƥ��str�е���һ��
			} else { // ��һ��ƥ�䲻�ɹ�
				// System.out.println("===");
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}

		// ģʽ��2������*�����ַ�����1����ģʽ��1��ƥ�䣬�򶼺���1λ������ֱ�ӷ���false
		if (strIndex != str.length
				&& (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] != '*')) {
			if (pattern[patternIndex] == str[strIndex]
					|| pattern[patternIndex] == '.') {
				// System.out.println("----");
				return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
			}
		}
		// ���������
		if (strIndex == str.length - 1 && patternIndex == pattern.length - 1) {

			if (pattern[patternIndex] == str[strIndex]
					|| pattern[patternIndex] == '.') {
				return true;
			}
			return false;
		}

		// System.out.println(patternIndex);
		return false;

	}

	public static void main(String[] args) {
		T53 t53 = new T53();

		System.out.println(t53.match("bcbbabab".toCharArray(),
				".*a*a".toCharArray()));

	}

	
}
