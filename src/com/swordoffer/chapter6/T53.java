package com.swordoffer.chapter6;

/**
 * 当模式中的第二个字符不是“*”时： 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。 2、如果
 * 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
 * 
 * 而当模式中的第二个字符是“*”时：
 * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
 * 1、模式后移2字符，相当于x*被忽略； 2、字符串后移1字符，模式后移2字符； 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
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

		// 第二个字符是'*'
		if (patternIndex + 1 < pattern.length
				&& pattern[patternIndex + 1] == '*') {
			// 第一个匹配成功 有三种情况

			if (strIndex != str.length
					&& (pattern[patternIndex] == str[strIndex] || pattern[patternIndex] == '.')) {
				// System.out.println("...");

				return matchCore(str, strIndex, pattern, patternIndex + 2)// 模式后移2字符，相当于x*被忽略；
						|| matchCore(str, strIndex + 1, pattern,
								patternIndex + 2)// 字符串后移1字符，模式后移2字符；
						|| matchCore(str, strIndex + 1, pattern, patternIndex);// *匹配1个，再匹配str中的下一个
			} else { // 第一个匹配不成功
				// System.out.println("===");
				return matchCore(str, strIndex, pattern, patternIndex + 2);
			}
		}

		// 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
		if (strIndex != str.length
				&& (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] != '*')) {
			if (pattern[patternIndex] == str[strIndex]
					|| pattern[patternIndex] == '.') {
				// System.out.println("----");
				return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
			}
		}
		// 到达最后了
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
