package com.swordoffer.chapter6;

public class T55 {
	
	
	StringBuffer sb = new StringBuffer();
	
	int[] hashTable = new int[256];//×Ö·ûµÄ´óÐ¡  0-255
	
	
	// Insert one char from stringstream
	public void Insert(char ch) {
		
		sb.append(ch);
		
		if(hashTable[ch] == 0) {
			hashTable[ch] = 1;
		} else {
			hashTable[ch] += 1;
		}
		
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char[] strs = sb.toString().toCharArray();
		for (int i = 0; i < strs.length; i++) {
			if(hashTable[strs[i]] == 1) {
				return strs[i];
			}
		}
		
		return '#';

	}
}
